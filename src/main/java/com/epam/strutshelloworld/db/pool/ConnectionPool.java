
package com.epam.strutshelloworld.db.pool;


import com.epam.strutshelloworld.db.DatabaseException;


public interface ConnectionPool<T> {
    
    ConnectionWrapper<T> getConnection() throws DatabaseException;
    void releaseConnection(ConnectionWrapper<T> connection);
    void close();
    
}