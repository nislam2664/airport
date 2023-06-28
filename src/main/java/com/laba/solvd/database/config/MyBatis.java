package com.laba.solvd.database.config;

import com.laba.solvd.database.factory.ConnectionMethod;
import com.laba.solvd.database.factory.ConnectionMethodFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class MyBatis implements ConnectionMethod {
    private static MyBatis INSTANCE;
    private static SqlSessionFactory sqlSessionFactory;
    private static final String path = "mybatis-config.xml";

    public MyBatis() {
        initialize();
    }

    @Override
    public void initialize() {
        try {
            InputStream inputStream = Resources.getResourceAsStream(path);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            System.out.println("Failed to find MyBatis configuration file");
        }
    }

    public static synchronized MyBatis getInstance() {
        if (INSTANCE == null && !ConnectionMethodFactory.isPool())
            INSTANCE = new MyBatis();
        return INSTANCE;
    }

    public SqlSession getSession() {
        return sqlSessionFactory.openSession();
    }
}
