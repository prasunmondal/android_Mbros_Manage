package com.prasunmondal.mbros_manage.Models

class Order {
    lateinit var customerId: String
    lateinit var customerName: String
    lateinit var pcs: String
    lateinit var kilos: String
    lateinit var pricePerKilo: String
    lateinit var previousDue: String

    constructor(
        customerId: String,
        customerName: String,
        pcs: String,
        kilos: String,
        pricePerKilo: String,
        previousDue: String
    ) {
        this.customerId = customerId
        this.customerName = customerName
        this.pcs = pcs
        this.kilos = kilos
        this.pricePerKilo = pricePerKilo
        this.previousDue = previousDue
    }


}