
package com.epam.strutshelloworld.model.businesslogic;

import com.epam.strutshelloworld.db.dao.INewsDAO;
import com.epam.strutshelloworld.model.entity.News;
import java.util.List;


public class POJONewsManager implements INewsManager {
    
    private INewsDAO newsDAO;

    public POJONewsManager(INewsDAO newsDAO) {
        this.newsDAO = newsDAO;
    }
    
    @Override
    public void addNews(News news) {
        newsDAO.addNews(news);
    }

    @Override
    public void updateNews(News news) {
        newsDAO.updateNews(news);
    }

    @Override
    public void deleteNews(long id) {
        newsDAO.deleteNews(id);
    }
    
    @Override
    public void deleteNewsList(long[] ids) {
        for(int i = 0; i < ids.length; i++) {
            newsDAO.deleteNews(ids[i]);
        }
    }

    @Override
    public News findNews(long id) {
        return newsDAO.findNews(id);
    }
    
    @Override
    public List<News> findAllNews() {
        return newsDAO.findAllNews(); 
    }
    
}