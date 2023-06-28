package com.laba.solvd.database.config;

import com.laba.solvd.database.factory.ConnectionMethod;
import com.laba.solvd.database.factory.ConnectionMethodFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

import static com.laba.solvd.database.Main.connectionFactory;

public class MyBatis implements ConnectionMethod {
    private static final Logger logger = LogManager.getLogger(MyBatis.class.getName());

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
            logger.error("Failed to find MyBatis configuration file");
        }
    }

    public static synchronized MyBatis getInstance() {
        if (INSTANCE == null && connectionFactory.isMyBatis())
            INSTANCE = (MyBatis) connectionFactory.getMethod();
        return INSTANCE;
    }

    public SqlSession getSession() {
        return sqlSessionFactory.openSession();
    }
}
