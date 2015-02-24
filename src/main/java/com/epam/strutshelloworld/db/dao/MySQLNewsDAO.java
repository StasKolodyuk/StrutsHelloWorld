
package com.epam.strutshelloworld.db.dao;

import com.epam.strutshelloworld.db.pool.ConnectionWrapper;
import com.epam.strutshelloworld.db.pool.MySQLConnectionPool;
import com.epam.strutshelloworld.model.entity.News;
import java.util.List;


public class MySQLNewsDAO implements INewsDAO {
        
    private MySQLConnectionPool connectionPool;

    public MySQLNewsDAO(MySQLConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
    

    @Override
    public List<News> findAllNews() {
        ConnectionWrapper connectionWrapper = connectionPool.getConnectionWrapper();
        
        connectionPool.releaseConnectionWrapper(connectionWrapper);
        return null;
    }

    @Override
    public void updateNews(News news) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addNews(News news) {
        connectionPool.getConnectionWrapper().getConnection();
        System.out.println("Adding News");
    }

}