
package com.epam.strutshelloworld.db.pool.mysql;

import com.epam.strutshelloworld.db.DatabaseException;
import com.epam.strutshelloworld.db.pool.ConnectionPool;
import com.epam.strutshelloworld.db.pool.ConnectionWrapper;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MySQLConnectionPool implements ConnectionPool<Connection> {
    
    private static final int POOL_CAPACITY = 10;
    private static final int POOL_START_SIZE = 3;
    private static final int MAX_WAIT_TIME_SECONDS = 5;
    private static final int MAX_CLOSING_TIME_MILLIS = 1000;
    
    private BlockingQueue<Connection> pool;
    private BlockingQueue<Connection> usedConnections;
    private AtomicInteger connectionCount;
    private Lock lock;
    private boolean enabled;
    private DBConnector dbConnector;

    private MySQLConnectionPool() throws DatabaseException {
        enabled = true;
        pool = new ArrayBlockingQueue<>(POOL_CAPACITY);
        usedConnections = new ArrayBlockingQueue<>(POOL_CAPACITY);
        connectionCount = new AtomicInteger();
        lock = new ReentrantLock();
    }
    
    public void initConnections() {
        for (int i = 0; i < POOL_START_SIZE; i++) {
            pool.offer(dbConnector.getConnection());
            connectionCount.incrementAndGet();
        }
    }
            
    public DBConnector getDbConnector() {
        return dbConnector;
    }

    public void setDbConnector(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }
    
    @Override
    public ConnectionWrapper<Connection> getConnection() {
        try {
            if(!enabled) {
                throw new DatabaseException("Connection pool is disabled");
            }
            Connection connection = pool.poll(MAX_WAIT_TIME_SECONDS, TimeUnit.SECONDS);
            lock.lock();
            if(connection == null) {
                if(connectionCount.get() < POOL_CAPACITY) {
                    connection = dbConnector.getConnection();
                    connectionCount.incrementAndGet();
                }
            }
            usedConnections.offer(connection);
            return new MySQLConnectionWrapper(connection);
        } catch(InterruptedException e) {
            throw new DatabaseException(e);
        } finally {
            lock.unlock();
        }
    }
    
    @Override
    public void releaseConnection(ConnectionWrapper<Connection> connection) {
        usedConnections.remove(connection.getConnection());
        pool.offer(connection.getConnection());
    }

    @Override
    public void close() {
        enabled = false;
        try {
            Thread.sleep(MAX_CLOSING_TIME_MILLIS);
        } catch (InterruptedException ex) {
            //LOGGER.error("Closing connection pool thread was suddenly interrupted", ex);
        }
        Iterator<Connection> usedConnectionsIterator = usedConnections.iterator();
        while(usedConnectionsIterator.hasNext()) {
            releaseConnection(new MySQLConnectionWrapper(usedConnectionsIterator.next()));
        }
        Iterator<Connection> poolIterator = pool.iterator();
        while(poolIterator.hasNext()) {
            closeConnection(poolIterator.next());
        }
    }
    
    private void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            //LOGGER.error("Closing a connection failed", e);
        }
    }
    
}