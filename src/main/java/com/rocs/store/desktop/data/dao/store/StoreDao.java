package com.rocs.store.desktop.data.dao.store;

import com.rocs.store.desktop.data.model.store.Item;
import com.rocs.store.desktop.data.model.store.Customer;
import com.rocs.store.desktop.data.model.store.Transaction;

import java.util.List;

public abstract class StoreDao {
    public abstract List<Item> getAllItems();

    public abstract List<Customer> getAllCustomers();

    public abstract boolean saveTransaction(Transaction transaction);

}
