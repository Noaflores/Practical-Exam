package com.rocs.store.desktop.data.dao.store.impl;

import com.rocs.store.desktop.data.connection.ConnectionHelper;
import com.rocs.store.desktop.data.dao.store.StoreDao;
import com.rocs.store.desktop.data.model.store.Customer;
import com.rocs.store.desktop.data.model.store.Item;
import com.rocs.store.desktop.data.model.store.Transaction;
import com.rocs.store.desktop.data.dao.utils.QueryConstant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class StoreDaoImpl extends StoreDao {
    private static final Logger logger = Logger.getLogger(StoreDaoImpl.class.getName());

    @Override
    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();

        try (Connection conn = ConnectionHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(QueryConstant.SELECT_ALL_ITEMS)) {

            while (rs.next()) {
                Item item = new Item();
                item.setItemId(rs.getString("item_id"));
                item.setDescription(rs.getString("item_desc"));
                item.setUnitPrice(rs.getDouble("unit_price"));
                items.add(item);
            }

        } catch (SQLException e) {
            logger.severe("Failed to retrieve items: " + e.getMessage());
        }

        return items;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();

        try (Connection conn = ConnectionHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(QueryConstant.SELECT_ALL_CUSTOMERS)) {

            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(rs.getInt("CUSTOMERID"));
                customer.setName(rs.getString("CUSTOMERNAME"));
                customer.setAddress(rs.getString("ADDRESS"));
                customer.setContactNumber(rs.getString("CONTACTNUMBER"));
                customers.add(customer);
            }

        } catch (SQLException e) {
            logger.severe("Failed to retrieve customers: " + e.getMessage());
        }

        return customers;
    }

    @Override
    public boolean saveTransaction(Transaction transaction) {
        try (Connection conn = ConnectionHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(QueryConstant.INSERT_TRANSACTION)) {

            stmt.setInt(1, transaction.getTransactionId());
            stmt.setInt(2, transaction.getCustomerId());
            stmt.setString(3, transaction.getItemId());
            stmt.setDate(4, new java.sql.Date(transaction.getTransactionDate().getTime()));

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            logger.severe("Failed to save transaction: " + e.getMessage());
            return false;
        }
    }
}
