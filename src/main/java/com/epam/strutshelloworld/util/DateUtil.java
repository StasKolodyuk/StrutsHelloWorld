
package com.epam.strutshelloworld.util;

import java.util.Date;


public class DateUtil {

    private DateUtil() {}
    
    public static java.sql.Date toSQLDate(Date utilDate) {
        return new java.sql.Date(utilDate.getTime());
    }
}
