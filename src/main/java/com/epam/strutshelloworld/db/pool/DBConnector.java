
package com.epam.strutshelloworld.db.pool;

import com.epam.strutshelloworld.db.DatabaseException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import oracle.jdbc.driver.OracleDriver;


public class DBConnector {
    
    private String url;
    private String user;
    private String password;

    public DBConnector() {
        try {
            //Locale.setDefault(Locale.ENGLISH);
            DriverManager.registerDriver(new OracleDriver());
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Connection getConnection() {
        try {
            Locale.setDefault(Locale.ENGLISH);
            return DriverManager.getConnection(url, user, password);
        } catch(SQLException e) {
            throw new DatabaseException(e);
        }
    }
    
}