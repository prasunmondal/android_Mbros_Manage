package com.prasunmondal.mbros_manage.DatabaseCalls;

import com.prasunmondal.mbros_manage.DatabaseUtils.FetchAllFromDB;
import com.prasunmondal.mbros_manage.Models.Customer;
import com.prasunmondal.mbros_manage.Models.Order;

import java.util.ArrayList;
import java.util.function.Consumer;

public class FetchAllOrders {
    public static void execute(final Consumer<ArrayList<Order>> onCompletion) throws Exception
    {
        FetchAllFromDB sd = new FetchAllFromDB(
                DatabaseStrings.TABNAME_ORDER,p1 -> parseAndExecute(p1, onCompletion));
        sd.execute();
    }

    private static void parseAndExecute(String jsonString, Consumer<ArrayList<Order>> onCompletion)
    {
        ArrayList<Order> order = new Order().parse(jsonString);
        onCompletion.accept(order);
    }
}
