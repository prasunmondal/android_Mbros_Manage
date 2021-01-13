package com.prasunmondal.mbros_manage.DatabaseUtils;

import com.prasunmondal.mbros_manage.DatabaseCalls.DatabaseStrings;

import org.json.JSONObject;

import java.net.URL;
import java.util.function.Consumer;

public class InsertDataToDB
{
    Consumer<String> onCompletion;
    JSONObject postDataParams = new JSONObject();
    URL scriptUrl;

    public InsertDataToDB(String data, String tabName, Consumer<String> onCompletion) throws Exception
    {
        this.onCompletion = onCompletion;

        scriptUrl = new URL(DatabaseStrings.GOOGLE_SCRIPT_URL);
        String sheetId = DatabaseStrings.SHEET_ID_PROD;

        postDataParams.put("data", data);
        postDataParams.put("sheetId", sheetId);
        postDataParams.put("tabName", tabName);
        postDataParams.put("opCode", "INSERT_UNIQUE");
    }

    public void execute()
    {
        ExecutePostCalls c=new ExecutePostCalls(scriptUrl,postDataParams,onCompletion);
        c.execute();
    }

}
