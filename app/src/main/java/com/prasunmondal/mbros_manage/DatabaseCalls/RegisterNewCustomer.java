package com.prasunmondal.mbros_manage.DatabaseCalls;

import com.prasunmondal.mbros_manage.DatabaseUtils.InsertUniqueDataToDB;
import com.prasunmondal.mbros_manage.Models.Customer;
import com.prasunmondal.mbros_manage.Utils.StringConstants;

import java.util.function.Consumer;

public class RegisterNewCustomer
{
    Consumer<String> onCompletion;

    public RegisterNewCustomer(Consumer<String> onCompletion) {
        this.onCompletion = onCompletion;
    }

    public void execute(Customer customer) throws Exception
    {
        InsertUniqueDataToDB sd = new InsertUniqueDataToDB(
                getStringToSave(customer),
                DatabaseStrings.TABNAME_REGISTER_CUSTOMER,
                DatabaseStrings.CONSTRAINTS_REGISTER_CUSTOMER_UNIQUE_COLUMNS, onCompletion);
        sd.execute();
    }

    private static String getStringToSave(Customer customer) {
        return customer.id + StringConstants.SEPARATOR_DB
                + customer.name + StringConstants.SEPARATOR_DB
                + customer.phoneNumber1;
    }
}
