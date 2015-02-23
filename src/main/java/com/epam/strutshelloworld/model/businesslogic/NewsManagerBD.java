
package com.epam.strutshelloworld.model.businesslogic;


public class NewsManagerBD {
    
    public static INewsManager getNewsManager() {
        return new POJONewsManager();
    }
    
}
