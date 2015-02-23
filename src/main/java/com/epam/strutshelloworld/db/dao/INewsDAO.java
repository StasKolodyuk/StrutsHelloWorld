
package com.epam.strutshelloworld.db.dao;

import com.epam.strutshelloworld.model.entity.News;
import java.util.List;


public interface INewsDAO {
    
    List<News> findAllNews();
    void updateNews(News news);
    void addNews(News news);
    
}