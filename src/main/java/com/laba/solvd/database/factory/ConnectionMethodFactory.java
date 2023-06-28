package com.laba.solvd.database.factory;

import com.laba.solvd.database.config.ConnectionPool;
import com.laba.solvd.database.config.MyBatis;

public class ConnectionMethodFactory {
    private static boolean isPool;

    public static ConnectionMethod getMethod(String method) {
        if (method == null)
            return null;
        if (method.equalsIgnoreCase("JDBC") || method.equalsIgnoreCase("Connection Pool")) {
            isPool = true;
            return new ConnectionPool();
        }
        isPool = false;
        return new MyBatis();
    }

    public static boolean isPool() {
        return isPool;
    }
}
