package com.rocs.store.desktop.app.facade.store.impl;

import com.rocs.store.desktop.app.facade.store.StoreFacade;
import com.rocs.store.desktop.data.model.store.Customer;
import com.rocs.store.desktop.data.model.store.Item;
import com.rocs.store.desktop.data.model.store.Transaction;

import java.util.List;
import java.util.logging.Logger;

public class StoreFacadeImpl extends StoreFacade {

    private ItemDao itemDao;
    private CustomerDao customerDao;
    private TransactionDao transactionDao;
    private final Logger logger = Logger.getLogger(StoreFacade.class.getName());

    public void StoreFacade(ItemDao itemDao, CustomerDao customerDao, TransactionDao transactionDao) {
        this.itemDao = itemDao;
        this.customerDao = customerDao;
        this.transactionDao = transactionDao;
    }

    public StoreFacadeImpl(ItemDao itemDao, CustomerDao customerDao, TransactionDao transactionDao) {
        this.itemDao = itemDao;
        this.customerDao = customerDao;
        this.transactionDao = transactionDao;
    }

    public List<Item> getAllItems() {
        logger.info("Retrieving all item records from database.");
        return itemDao.getAllItems();
    }

    public List<Customer> getAllCustomers() {
        logger.info("Retrieving all customer records from database.");
        return customerDao.getAllCustomers();
    }

    public void saveTransaction(Transaction transaction) {
        logger.info("Saving transaction to database: " + transaction);
        transactionDao.saveTransaction(transaction);
    }
}

