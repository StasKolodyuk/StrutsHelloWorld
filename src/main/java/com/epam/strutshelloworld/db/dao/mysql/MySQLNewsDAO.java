
package com.epam.strutshelloworld.db.dao.mysql;

import com.epam.strutshelloworld.db.dao.INewsDAO;
import com.epam.strutshelloworld.model.entity.News;
import java.sql.Connection;
import java.util.List;


public class MySQLNewsDAO implements INewsDAO {
        
    private Connection connection;

    public MySQLNewsDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<News> findAllNews() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateNews(News news) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addNews(News news) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}