package com.prasunmondal.mbros_manage.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.prasunmondal.mbros_manage.DatabaseCalls.FetchAllCustomers
import com.prasunmondal.mbros_manage.Models.Customer
import com.prasunmondal.mbros_manage.R
import java.util.ArrayList
import java.util.function.Consumer

class ViewCustomers : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_customers)
    }

    fun showCustomerData(customers: ArrayList<Customer>) {
        var view = findViewById<TextView>(R.id.view_customers_viewArea);
        var str = ""
        for(customer in customers) {
            str += customer.name + "\n"
        }
        view.text = str
    }

    fun onClickRefreshCustomerListButton(view: View) {
        FetchAllCustomers.execute(Consumer { p1-> showCustomerData(p1)});
    }
}