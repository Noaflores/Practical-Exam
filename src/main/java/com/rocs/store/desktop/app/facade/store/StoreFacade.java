package com.rocs.store.desktop.app.facade.store;

import com.rocs.store.desktop.data.model.store.Item;
import com.rocs.store.desktop.data.model.store.Customer;
import com.rocs.store.desktop.data.model.store.Transaction;

import java.util.List;

public class StoreFacade {

    public interface ItemDao {
        List<Item> getAllItems();
    }

    public interface CustomerDao {
        List<Customer> getAllCustomers();
    }

    public interface TransactionDao {
        void saveTransaction(Transaction transaction);
    }
}