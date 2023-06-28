package com.laba.solvd.database.persistence.mapper;

import com.laba.solvd.database.config.MyBatis;
import com.laba.solvd.database.domain.Airplane;
import com.laba.solvd.database.domain.Employee;
import com.laba.solvd.database.domain.Package;
import com.laba.solvd.database.persistence.AirplaneRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class AirplaneMapperImpl implements AirplaneRepository {
    private static final Logger logger = LogManager.getLogger(AirplaneMapperImpl.class.getName());
    private static final MyBatis MY_BATIS = MyBatis.getInstance();

    @Override
    public void create(Airplane airplane) {
        try (SqlSession session = MY_BATIS.getSession();){
            session.insert("create", airplane);
            session.commit();
            logger.info("Airplane created in SqlSession");
        }
    }

    @Override
    public void update(Airplane airplane) {
        try (SqlSession session = MY_BATIS.getSession();){
            session.update("update", airplane);
            session.commit();
            logger.info("Airplane created in SqlSession");
        }
    }

    @Override
    public void delete(Airplane airplane) {
        try (SqlSession session = MY_BATIS.getSession();){
            session.delete("delete", airplane);
            session.commit();
            logger.info("Airplane deleted in SqlSession");
        }
    }

    @Override
    public Airplane read(int id) {
        try (SqlSession session = MY_BATIS.getSession();){
            logger.info("Read airplane in SqlSession");
            return session.selectOne("read");
        }
    }

    @Override
    public List<Airplane> getAll() {
        try (SqlSession session = MY_BATIS.getSession();) {
            logger.info("Received all airplanes");
            return session.selectList("getAll");
        }
    }

    @Override
    public List<Package> getPackagesByAirplaneId(int id) {
        try (SqlSession session = MY_BATIS.getSession();) {
            logger.info("Received all packages in airplane");
            return session.selectList("getPackagesByAirplaneId");
        }
    }

    @Override
    public List<Employee> getEmployeesByAirplaneId(int id) {
        try (SqlSession session = MY_BATIS.getSession();) {
            logger.info("Received all employees in airplane");
            return session.selectList("getEmployeesByAirplaneId");
        }
    }

}
