
package com.epam.strutshelloworld.db.pool;

import com.epam.strutshelloworld.db.DatabaseException;
import com.epam.strutshelloworld.db.pool.ConnectionWrapper;
import java.sql.Connection;
import java.sql.SQLException;


public class OracleConnectionWrapper extends ConnectionWrapper<Connection> {

    public OracleConnectionWrapper(Connection connection) {
        super(connection);
    }

    @Override
    public void setAutoCommit(boolean autoCommit) throws DatabaseException {
        try {
            getConnection().setAutoCommit(autoCommit);
        } catch(SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public void rollback() throws DatabaseException {
        try {
            getConnection().rollback();
        } catch(SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public void commit() throws DatabaseException {
        try {
            getConnection().commit();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }
    
}
