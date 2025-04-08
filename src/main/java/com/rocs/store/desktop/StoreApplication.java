package com.rocs.store.desktop;

import com.rocs.store.desktop.data.dao.store.impl.StoreDaoImpl;
import com.rocs.store.desktop.data.model.store.Customer;
import com.rocs.store.desktop.data.model.store.Item;
import com.rocs.store.desktop.data.model.store.Transaction;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class StoreApplication {

    private static final Logger logger = Logger.getLogger(StoreApplication.class.getName());

    public static void main(String[] args) {
        StoreDaoImpl dao = new StoreDaoImpl();


        List<Item> items = dao.getAllItems();
        System.out.println("Items:");
        for (Item item : items) {
            System.out.println(item.getItemId() + " - " + item.getDescription() + " - " + item.getUnitPrice());
        }


        List<Customer> customers = dao.getAllCustomers();
        System.out.println("\nCustomers:");
        for (Customer customer : customers) {
            System.out.println(customer.getCustomerId() + " - " + customer.getName() + " - " + customer.getAddress());
        }


        try {
            Transaction transaction = new Transaction();
            transaction.setId(100);
            transaction.setTransactionId(500);
            transaction.setCustomerId(1);
            transaction.setItemId("01");
            Date date = new SimpleDateFormat("MM-dd-yyyy").parse("04-11-2024");
            transaction.setTransactionDate(date);

            boolean success = dao.saveTransaction(transaction);
            if (success) {
                logger.info("Transaction saved successfully.");
            } else {
                logger.warning("Failed to save transaction.");
            }
        } catch (Exception e) {
            logger.severe("Error creating transaction: " + e.getMessage());
        }
    }
}
