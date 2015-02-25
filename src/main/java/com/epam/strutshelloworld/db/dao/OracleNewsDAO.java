
package com.epam.strutshelloworld.db.dao;

import com.epam.strutshelloworld.db.DatabaseException;
import com.epam.strutshelloworld.db.pool.ConnectionWrapper;
import com.epam.strutshelloworld.db.pool.OracleConnectionPool;
import com.epam.strutshelloworld.model.entity.News;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class OracleNewsDAO implements INewsDAO {
    
    private static final String INSERT_NEWS_QUERY = "INSERT INTO NEWS (TITLE, BRIEF, CONTENT) VALUES (?, ?, ?)";
    
        
    private OracleConnectionPool connectionPool;

    public OracleNewsDAO(OracleConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
    

    @Override
    public List<News> findAllNews() {
        
        return null;
    }

    @Override
    public void updateNews(News news) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addNews(News news) {
        ConnectionWrapper<Connection> connectionWrapper = connectionPool.getConnectionWrapper();
        try {
            PreparedStatement query = connectionWrapper.getConnection().prepareStatement(INSERT_NEWS_QUERY);
            query.setString(1, news.getTitle());
            query.setString(2, news.getBrief());
            query.setString(3, news.getContent());
            query.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        } finally {
            connectionPool.releaseConnectionWrapper(connectionWrapper);
        }

    }

}