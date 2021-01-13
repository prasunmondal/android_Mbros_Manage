package com.prasunmondal.mbros_manage.Models

import com.google.gson.reflect.TypeToken
import com.prasunmondal.mbros_manage.Utils.DataParser
import java.util.ArrayList

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

    constructor()

    fun parse(p2: String): ArrayList<Order> {
        return DataParser.parseJSONObject(object :
            TypeToken<ArrayList<Order>>() {}.type, p2, "records")
    }

    override fun toString(): String {
        return "ID: $customerId" +
                "\nName: $customerName" +
                "\nPieces: $pcs" +
                "\nKilos: $kilos" +
                "\nPricePerKilo: $pricePerKilo" +
                "\nPreviousDue: $previousDue"
    }
}