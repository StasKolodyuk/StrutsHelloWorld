
package com.epam.strutshelloworld.db.pool;

import com.epam.strutshelloworld.db.DatabaseException;


public abstract class ConnectionWrapper<T> {
    
    private T connection;

    public ConnectionWrapper(T connection) {
        this.connection = connection;
    }
    
    public abstract void setAutoCommit(boolean autoCommit) throws DatabaseException;
    public abstract void commit() throws DatabaseException;
    public abstract void rollback() throws DatabaseException;

    public T getConnection() {
        return connection;
    }

    public void setConnection(T connection) {
        this.connection = connection;
    }

}