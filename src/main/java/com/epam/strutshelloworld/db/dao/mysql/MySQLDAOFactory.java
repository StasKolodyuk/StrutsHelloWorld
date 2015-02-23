
package com.epam.strutshelloworld.db.dao.mysql;

import by.bsu.kolodyuk.bettingapp.db.pool.ConnectionWrapper;
import com.epam.strutshelloworld.db.dao.DAOFactory;
import com.epam.strutshelloworld.db.dao.INewsDAO;
import java.sql.Connection;


public class MySQLDAOFactory extends DAOFactory<Connection> {

    @Override
    public INewsDAO getNewsDAO(ConnectionWrapper<Connection> connectionWrapper) {
        return new MySQLNewsDAO(connectionWrapper.getConnection());
    }
    
}