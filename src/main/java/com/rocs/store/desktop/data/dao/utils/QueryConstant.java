package com.rocs.store.desktop.data.dao.utils;

public class QueryConstant {

    public static final String SELECT_ALL_ITEMS = "SELECT * FROM ITEMS";
    public static final String SELECT_ALL_CUSTOMERS = "SELECT * FROM CUSTOMERS";
    public static final String INSERT_TRANSACTION =
            "INSERT INTO TRANS (ID, TRANSACTION_ID, CUSTOMER_ID, ITEM_ID, TRANSACTION_DATE) " +
                    "VALUES (TRANS_SEQ.NEXTVAL, ?, ?, ?, ?)";

}
