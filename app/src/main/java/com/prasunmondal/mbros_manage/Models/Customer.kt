package com.prasunmondal.mbros_manage.Models

import com.prasunmondal.mbros_manage.DatabaseCalls.RegisterNewCustomer

class Customer {
    lateinit var id: String
    lateinit var name: String
    lateinit var phoneNumber1: String
    lateinit var phoneNumber2: String
    lateinit var address: String

    fun registerCustomer(customer: Customer) {
        RegisterNewCustomer({}).execute(customer)
    }
}