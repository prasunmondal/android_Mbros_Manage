package com.prasunmondal.mbros_manage.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.prasunmondal.mbros_manage.DatabaseCalls.FetchAllOrders
import com.prasunmondal.mbros_manage.Models.Order
import com.prasunmondal.mbros_manage.R
import java.util.ArrayList

class ViewOrders : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_orders)
    }

    fun showCustomerData(orders: ArrayList<Order>) {
        var view = findViewById<TextView>(R.id.view_orders_viewArea);
        var str = ""
        for(order in orders) {
            str += order.toString() + "\n"
        }
        view.text = str
    }

    fun onClickRefreshOrdersButton(view: View) {
        FetchAllOrders.execute( { p1-> showCustomerData(p1)});
    }
}