package com.erictoader.ordersdatabasemanagement.DataAccess;

import com.erictoader.ordersdatabasemanagement.Model.Product;
/*
 *   This class is for Product-based data access operations.
 *   @author Toader Eric-Stefan
 */
public class ProductDAO extends GenericDAO<Product> {
    public ProductDAO() {
        super(Product.class);
    }
}
