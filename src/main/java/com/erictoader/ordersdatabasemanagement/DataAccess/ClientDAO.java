package com.erictoader.ordersdatabasemanagement.DataAccess;

import com.erictoader.ordersdatabasemanagement.Model.Client;
/*
 *   This class is for Client-based data access operations.
 *   @author Toader Eric-Stefan
 */
public class ClientDAO extends GenericDAO<Client> {
    public ClientDAO() {
        super(Client.class);
    }
}
