package com.erictoader.ordersdatabasemanagement.DataAccess;

import com.erictoader.ordersdatabasemanagement.Model.Orders;
/*
 *   This class is for Orders-based data access operations.
 *   @author Toader Eric-Stefan
 */
public class OrdersDAO extends GenericDAO<Orders> {
    public OrdersDAO() {
        super(Orders.class);
    }
}
