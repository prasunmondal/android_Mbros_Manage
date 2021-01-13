package com.prasunmondal.mbros_manage.Models

import com.google.gson.reflect.TypeToken
import com.prasunmondal.mbros_manage.DatabaseCalls.RegisterNewCustomer
import com.prasunmondal.mbros_manage.Utils.DataParser
import java.util.*

class Customer {
    lateinit var id: String
    lateinit var name: String
    lateinit var phoneNumber1: String
    lateinit var phoneNumber2: String
    lateinit var address: String

    fun registerCustomer(customer: Customer) {
        RegisterNewCustomer({}).execute(customer)
    }

    fun getCustomers() {

    }

    fun parse(p2: String): ArrayList<Customer> {
        return DataParser.parseJSONObject(object :
            TypeToken<ArrayList<Customer>>() {}.type, p2, "records")
    }
}