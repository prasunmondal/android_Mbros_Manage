package com.prasunmondal.mbros_manage.DatabaseCalls;

import com.prasunmondal.mbros_manage.DatabaseUtils.InsertUniqueDataToDB;
import com.prasunmondal.mbros_manage.DatabaseUtils.UpdateDataInDB;
import com.prasunmondal.mbros_manage.Models.Customer;
import com.prasunmondal.mbros_manage.Models.Order;
import com.prasunmondal.mbros_manage.Utils.StringConstants;

import java.util.function.Consumer;

public class AddNewOrder
{
    public void execute(Order order, Consumer<String> onCompletion) throws Exception
    {
        UpdateDataInDB sd = new UpdateDataInDB(
                getStringToSave(order),
                DatabaseStrings.TABNAME_ORDER,
                order.customerId,
                0,
                onCompletion);
        sd.execute();
    }

    private static String getStringToSave(Order order) {
        return order.customerId + StringConstants.SEPARATOR_DB
                + order.customerName + StringConstants.SEPARATOR_DB
                + order.pcs + StringConstants.SEPARATOR_DB
                + order.kilos + StringConstants.SEPARATOR_DB
                + order.pricePerKilo + StringConstants.SEPARATOR_DB
                + order.previousDue;
    }
}
