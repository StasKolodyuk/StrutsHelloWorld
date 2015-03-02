
package com.epam.strutshelloworld.listener;

import java.util.Locale;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.struts.Globals;


public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("setting locale");
        sce.getServletContext().setAttribute(Globals.LOCALE_KEY, Locale.ENGLISH);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
    
}
