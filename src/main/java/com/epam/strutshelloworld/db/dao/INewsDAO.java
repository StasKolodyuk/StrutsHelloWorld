
package com.epam.strutshelloworld.db.dao;

import com.epam.strutshelloworld.model.entity.News;
import java.util.List;


public interface INewsDAO {
    
    List<News> findAllNews();
    News findNews(long id);
    void updateNews(News news);
    void deleteNews(long id);
    void addNews(News news);
    
}