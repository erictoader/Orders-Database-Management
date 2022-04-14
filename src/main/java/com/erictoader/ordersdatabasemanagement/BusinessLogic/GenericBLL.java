package com.erictoader.ordersdatabasemanagement.BusinessLogic;

import com.erictoader.ordersdatabasemanagement.DataAccess.GenericDAO;
import java.util.List;
/*
*   This class is for generic business logic operations.
*   @author Toader Eric-Stefan
*/
public class GenericBLL<T> {
    private final Class<T> type;
    private final GenericDAO<T> dao;

    @SuppressWarnings("unchecked")
    public GenericBLL(Class<T> classType) {
        this.type = classType;
        this.dao = new GenericDAO<>(classType);
    }

    /*
    *   Business logic method to get all entries in a table
    *   @return A list of all table entries
     */
    public List<T> findAll() {
        return dao.findAll();
    }

    /*
    *   Business logic method to insert a given object into a table
    */
    public void insert(T t) {
        dao.insert(t);
    }

    /*
    *   Business logic method to update the values of an entry
    */
    public void update(T t) {
        dao.update(t);
    }

    /*
    *   Business logic method to delete a table entry
    */
    public void delete(int id) {
        dao.delete(id);
    }
}
