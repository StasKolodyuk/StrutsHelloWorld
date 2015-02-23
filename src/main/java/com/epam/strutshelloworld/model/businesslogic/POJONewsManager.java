
package com.epam.strutshelloworld.model.businesslogic;

import com.epam.strutshelloworld.db.dao.INewsDAO;
import com.epam.strutshelloworld.db.pool.ConnectionPool;
import com.epam.strutshelloworld.model.entity.News;
import java.util.ArrayList;
import java.util.List;


public class POJONewsManager implements INewsManager {
    
    private INewsDAO newsDAO;
    private ConnectionPool connectionPool;

    public POJONewsManager(INewsDAO newsDAO, ConnectionPool connectionPool) {
        this.newsDAO = newsDAO;
        this.connectionPool = connectionPool;
    }

    POJONewsManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void addNews(News news) {
        
    }

    @Override
    public void updateNews(News news) {

    }

    @Override
    public List<News> getAllNews() {
        return new ArrayList<>(); 
    }
    
}