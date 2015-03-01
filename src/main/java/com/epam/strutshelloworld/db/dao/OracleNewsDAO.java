
package com.epam.strutshelloworld.db.dao;

import com.epam.strutshelloworld.db.DatabaseException;
import com.epam.strutshelloworld.db.pool.ConnectionWrapper;
import com.epam.strutshelloworld.db.pool.OracleConnectionPool;
import com.epam.strutshelloworld.model.entity.News;
import com.epam.strutshelloworld.util.DateUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OracleNewsDAO implements INewsDAO {
    
    private static final String INSERT_NEWS_QUERY = "INSERT INTO NEWS (TITLE, POST_DATE, BRIEF, CONTENT) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_NEWS_QUERY = "UPDATE NEWS SET TITLE = ?, POST_DATE = ?, BRIEF = ?, CONTENT = ? WHERE ID = ?";
    private static final String SELECT_ALL_NEWS_QUERY = "SELECT * FROM NEWS";
    private static final String SELECT_NEWS_QUERY = "SELECT * FROM NEWS WHERE ID = ?";
    private static final String DELETE_NEWS_QUERY = "DELETE FROM NEWS WHERE ID = ?";
        
    private OracleConnectionPool connectionPool;

    public OracleNewsDAO(OracleConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
    
    @Override
    public List<News> findAllNews() {
        ConnectionWrapper<Connection> connectionWrapper = connectionPool.getConnectionWrapper();
        try {
            PreparedStatement query = connectionWrapper.getConnection().prepareStatement(SELECT_ALL_NEWS_QUERY);
            ResultSet newsResultSet = query.executeQuery();
            List<News> newsList = new ArrayList<>();
            while(newsResultSet.next()) {
                newsList.add(buildNews(newsResultSet));
            }
            return newsList;
        } catch(SQLException e) {
            throw new DatabaseException(e);
        } finally {
            connectionPool.releaseConnectionWrapper(connectionWrapper);
        }
    }

    @Override
    public News findNews(long id) {
        ConnectionWrapper<Connection> connectionWrapper = connectionPool.getConnectionWrapper();
        try {
            PreparedStatement query = connectionWrapper.getConnection().prepareStatement(SELECT_NEWS_QUERY);
            query.setLong(1, id);
            ResultSet newsResultSet = query.executeQuery();
            News news = null;
            if(newsResultSet.next()) {
                news = buildNews(newsResultSet);
            }
            return news;
        } catch(SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public void updateNews(News news) {
        ConnectionWrapper<Connection> connectionWrapper = connectionPool.getConnectionWrapper();
        try{
            PreparedStatement query = connectionWrapper.getConnection().prepareStatement(UPDATE_NEWS_QUERY);
            query.setString(1, news.getTitle());
            query.setDate(2, DateUtil.toSQLDate(news.getDate()));
            query.setString(3, news.getBrief());
            query.setString(4, news.getContent());
            query.setLong(5, news.getId());
            query.executeUpdate();
        } catch(SQLException e) {
            throw new DatabaseException(e);
        } finally {
            connectionPool.releaseConnectionWrapper(connectionWrapper);
        }
    }

    @Override
    public void addNews(News news) {
        ConnectionWrapper<Connection> connectionWrapper = connectionPool.getConnectionWrapper();
        try {
            PreparedStatement query = connectionWrapper.getConnection().prepareStatement(INSERT_NEWS_QUERY);
            query.setString(1, news.getTitle());
            query.setDate(2, DateUtil.toSQLDate(news.getDate()));
            query.setString(3, news.getBrief());
            query.setString(4, news.getContent());
            query.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        } finally {
            connectionPool.releaseConnectionWrapper(connectionWrapper);
        }
    }

    @Override
    public void deleteNews(long id) {
        ConnectionWrapper<Connection> connectionWrapper = connectionPool.getConnectionWrapper();
        try {
            PreparedStatement query = connectionWrapper.getConnection().prepareStatement(DELETE_NEWS_QUERY);
            query.setLong(1, id);
            query.executeUpdate();
        } catch(SQLException e) {
            throw new DatabaseException(e);
        } finally {
            connectionPool.releaseConnectionWrapper(connectionWrapper);
        }
    }
    
    private News buildNews(ResultSet newsResultSet) throws SQLException {
        News news = new News();
        news.setId(newsResultSet.getLong("ID"));
        news.setTitle(newsResultSet.getString("TITLE"));
        news.setDate(newsResultSet.getDate("POST_DATE"));
        news.setBrief(newsResultSet.getString("BRIEF"));
        news.setContent(newsResultSet.getString("CONTENT"));
        return news;
    }
    
}