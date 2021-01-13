package com.prasunmondal.mbros_manage.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.prasunmondal.mbros_manage.Models.Customer
import com.prasunmondal.mbros_manage.R

class RegisterCustomer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_customer)

    }

    private fun getUserId(): String {
        return findViewById<TextView>(R.id.registerCustomer_userId).text.toString()
    }

    private fun getName(): String {
        return findViewById<TextView>(R.id.registerCustomer_name).text.toString()
    }

    private fun getPhoneNumber1(): String {
        return findViewById<TextView>(R.id.registerCustomer_phoneNumber).text.toString()
    }

    fun onClickSaveButton(view: View) {
        var customer = Customer()
        customer.id = getUserId()
        customer.name = getName()
        customer.phoneNumber1 = getPhoneNumber1()
        customer.registerCustomer(customer)
    }
}