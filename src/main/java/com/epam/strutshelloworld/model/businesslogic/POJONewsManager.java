
package com.epam.strutshelloworld.model.businesslogic;

import by.bsu.kolodyuk.bettingapp.db.dao.DAOFactory;
import com.epam.strutshelloworld.db.dao.INewsDAO;
import com.epam.strutshelloworld.model.entity.News;
import java.util.List;


public class POJONewsManager implements INewsManager {
    
    private INewsDAO newsDAO;

    public POJONewsManager() {
        //newsDAO = ;
    }
    
    @Override
    public void addNews(News news) {
        
    }

    @Override
    public void updateNews(News news) {

    }

    @Override
    public List<News> getAllNews() {

    }
    
}
