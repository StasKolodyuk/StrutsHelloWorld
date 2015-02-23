
package com.epam.strutshelloworld.db.pool.mysql;

import com.epam.strutshelloworld.db.DatabaseException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnector {
    
    private String url;
    private String user;
    private String password;

    public DBConnector(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }
    
    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
    
    public Connection getConnection() throws DatabaseException {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch(SQLException e) {
            throw new DatabaseException(e);
        }
    }
    
}