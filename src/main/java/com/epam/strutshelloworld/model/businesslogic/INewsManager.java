
package com.epam.strutshelloworld.model.businesslogic;

import com.epam.strutshelloworld.model.entity.News;
import java.util.List;


public interface INewsManager {
    
    void addNews(News news);
    void updateNews(News news);
    List<News> getAllNews();
    
}
