
package com.epam.strutshelloworld.model.businesslogic;

import com.epam.strutshelloworld.db.dao.INewsDAO;
import com.epam.strutshelloworld.db.pool.IConnectionPool;
import com.epam.strutshelloworld.model.entity.News;
import java.util.ArrayList;
import java.util.List;


public class POJONewsManager implements INewsManager {
    
    private INewsDAO newsDAO;

    public POJONewsManager(INewsDAO newsDAO) {
        this.newsDAO = newsDAO;
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