
package com.epam.strutshelloworld.model.businesslogic;

import com.epam.strutshelloworld.model.entity.News;
import java.util.List;


public interface INewsManager {
    
    void addNews(News news);
    void updateNews(News news);
    void deleteNews(long id);
    void deleteNewsList(long[] ids);
    News findNews(long id);
    List<News> findAllNews();
    
}
