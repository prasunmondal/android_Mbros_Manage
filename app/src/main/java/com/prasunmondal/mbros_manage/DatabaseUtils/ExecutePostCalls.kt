package com.prasunmondal.mbros_manage.DatabaseUtils

import android.os.AsyncTask
import android.util.Log
import com.google.gson.GsonBuilder
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.reflect.Type
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import java.util.*
import java.util.function.Consumer
import javax.net.ssl.HttpsURLConnection


class ExecutePostCalls(
    var scriptUrl: URL,
    var postDataParams: JSONObject,
    var onCompletion: Consumer<String>
) :
    AsyncTask<String?, Void?, String>() {
    override fun onPreExecute() {}

    override fun doInBackground(vararg p0: String?): String {
        return try {
            Log.e("params", postDataParams.toString())
            val conn = scriptUrl.openConnection() as HttpURLConnection
            conn.readTimeout = 15000
            conn.connectTimeout = 15000
            conn.requestMethod = "POST"
            conn.doInput = true
            conn.doOutput = true
            val os = conn.outputStream
            val writer = BufferedWriter(
                OutputStreamWriter(os, "UTF-8")
            )
            writer.write(getPostDataString(postDataParams))
            writer.flush()
            writer.close()
            os.close()
            val responseCode = conn.responseCode
            if (responseCode == HttpsURLConnection.HTTP_OK) {
                val `in` = BufferedReader(InputStreamReader(conn.inputStream))
                val sb = StringBuffer("")
                var line: String? = ""
                while (`in`.readLine().also { line = it } != null) {
                    sb.append(line)
                    break
                }
                `in`.close()
                sb.toString()
            } else {
                "false : $responseCode"
            }
        } catch (e: Exception) {
            "Exception: " + e.message
        }
    }

    override fun onPostExecute(result: String) {
        Log.i("DBCall Result: ", result)
        if(onCompletion!=null)
            onCompletion.accept(result)
    }

    @Throws(Exception::class)
    fun getPostDataString(params: JSONObject): String {
        val result = StringBuilder()
        var first = true
        val itr = params.keys()
        while (itr.hasNext()) {
            val key = itr.next()
            val value = params[key]
            if (first) first = false else result.append("&")
            result.append(URLEncoder.encode(key, "UTF-8"))
            result.append("=")
            result.append(URLEncoder.encode(value.toString(), "UTF-8"))
        }
        return result.toString()
    }

    companion object {
        fun <T> parseJSONObject(type: Type?, p1: JSONObject?, arrayLabel: String?): ArrayList<T>? {
            if (p1 == null) {
                return null
            }
            var jsonarray: JSONArray? = null
            try {
                jsonarray = p1.getJSONArray(arrayLabel)
            } catch (e: Exception) {
                Log.e("parseJSONObject", "Error while parsing")
            }
            return GsonBuilder().create().fromJson(jsonarray.toString(), type)
        }
    }
}