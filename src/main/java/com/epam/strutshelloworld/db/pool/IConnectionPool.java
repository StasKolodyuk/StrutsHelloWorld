
package com.epam.strutshelloworld.db.pool;


import com.epam.strutshelloworld.db.DatabaseException;


public interface IConnectionPool<T> {
    
    ConnectionWrapper<T> getConnectionWrapper() throws DatabaseException;
    void releaseConnectionWrapper(ConnectionWrapper<T> connection);
    void close();
    
}