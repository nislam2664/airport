package com.laba.solvd.database.persistence.mapper;

import com.laba.solvd.database.config.MyBatis;
import com.laba.solvd.database.domain.Airplane;
import com.laba.solvd.database.domain.AirplaneType;
import com.laba.solvd.database.persistence.AirplaneTypeRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class AirplaneTypeMapperImpl implements AirplaneTypeRepository {
    private static final Logger logger = LogManager.getLogger(AirplaneTypeMapperImpl.class.getName());
    private static final MyBatis MY_BATIS = MyBatis.getInstance();

    @Override
    public void create(AirplaneType airplaneType) {
        try (SqlSession session = MY_BATIS.getSession();){
            session.insert("create", airplaneType);
            session.commit();
            logger.info("Airplane type created in SqlSession");
        }
    }

    @Override
    public void update(AirplaneType airplaneType) {
        try (SqlSession session = MY_BATIS.getSession();){
            session.update("update", airplaneType);
            session.commit();
            logger.info("Airplane type updated in SqlSession");
        }
    }

    @Override
    public void delete(AirplaneType airplaneType) {
        try (SqlSession session = MY_BATIS.getSession();){
            session.delete("delete", airplaneType);
            session.commit();
            logger.info("Airplane type deleted in SqlSession");
        }
    }

    @Override
    public AirplaneType read(int id) {
        try (SqlSession session = MY_BATIS.getSession();){
            logger.info("Read airplane type in SqlSession");
            return session.selectOne("read");
        }
    }

    @Override
    public List<AirplaneType> getAll() {
        try (SqlSession session = MY_BATIS.getSession();) {
            logger.info("Received all airplane types");
            return session.selectList("getAll");
        }
    }

    @Override
    public void setAirplaneType(AirplaneType airplaneType, Airplane airplane) {
        try (SqlSession session = MY_BATIS.getSession()) {
            AirplaneTypeRepository typeRepo = session.getMapper(AirplaneTypeRepository.class);
            typeRepo.setAirplaneType(airplaneType, airplane);
            session.commit();
            logger.info("Airplane type linked to airplane");
        }
    }
}
