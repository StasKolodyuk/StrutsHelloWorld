
package com.epam.strutshelloworld.db.pool;

import by.bsu.kolodyuk.bettingapp.db.pool.ConnectionWrapper;
import com.epam.strutshelloworld.db.DatabaseException;


public interface ConnectionPool<T> {
    
    ConnectionWrapper<T> getConnection() throws DatabaseException;
    void releaseConnection(ConnectionWrapper<T> connection);
    void close();
    
}