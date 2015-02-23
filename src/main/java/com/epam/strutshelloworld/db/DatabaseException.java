
package com.epam.strutshelloworld.db;


public class DatabaseException extends RuntimeException {

    public DatabaseException() {
    }

    public DatabaseException(String string) {
        super(string);
    }

    public DatabaseException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public DatabaseException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
