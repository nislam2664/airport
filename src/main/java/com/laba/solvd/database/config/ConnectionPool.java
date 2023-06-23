package com.laba.solvd.database.config;

import com.laba.solvd.database.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class ConnectionPool {
    private static final Logger logger = LogManager.getLogger(ConnectionPool.class.getName());

    private static ConnectionPool INSTANCE;
    private final ArrayList<Connection> connectionPool;

    private String driver;
    private String url;
    private String username;
    private String password;
    private int poolSize;

    public ConnectionPool() {
        try {
            driver = Config.DRIVER.getValue();
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            logger.error("Unable to find driver!", e);
        }

        url = Config.URL.getValue();
        username = Config.USERNAME.getValue();
        password = Config.PASSWORD.getValue();
        poolSize = Integer.parseInt(Config.POOL_SIZE.getValue());
        System.out.println(poolSize);

        INSTANCE = new ConnectionPool();
        connectionPool = new ArrayList<>(poolSize);
        IntStream.range(0, poolSize).boxed().forEach((i -> connectionPool.add(createConnection())));
    }

    public static ConnectionPool getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ConnectionPool();
        return INSTANCE;
    }

    public Connection createConnection() {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Unable to create connection");
        }
    }

    public synchronized Connection getConnection() {
        if (connectionPool.isEmpty()) {
            try {
                while (connectionPool.isEmpty())
                    connectionPool.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException("Connection unavailable");
            }
        }

        return connectionPool.remove(connectionPool.size() - 1);
    }

    public synchronized void releaseConnection(Connection connection) {
        if(connection != null)
            connectionPool.add(connection);
    }
}
