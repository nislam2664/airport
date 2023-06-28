package com.laba.solvd.database.persistence.mapper;

import com.laba.solvd.database.config.MyBatis;
import com.laba.solvd.database.domain.Airline;
import com.laba.solvd.database.domain.Airplane;
import com.laba.solvd.database.persistence.AirlineRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class AirlineMapperImpl implements AirlineRepository {
    private static final Logger logger = LogManager.getLogger(AirlineMapperImpl.class.getName());
    private static final MyBatis MY_BATIS = MyBatis.getInstance();

    @Override
    public void create(Airline airline) {
        try (SqlSession session = MY_BATIS.getSession();){
            session.insert("create", airline);
            session.commit();
            logger.info("Airline created in SqlSession");
        }
    }

    @Override
    public void update(Airline airline) {
        try (SqlSession session = MY_BATIS.getSession();){
            session.update("update", airline);
            session.commit();
            logger.info("Airline updated in SqlSession");
        }
    }

    @Override
    public void delete(Airline airline) {
        try (SqlSession session = MY_BATIS.getSession();){
            session.delete("delete", airline);
            session.commit();
            logger.info("Airline deleted in SqlSession");
        }
    }

    @Override
    public Airline read(int id) {
        try (SqlSession session = MY_BATIS.getSession();){
            logger.info("Read airline in SqlSession");
            return session.selectOne("read");
        }
    }

    @Override
    public List<Airline> getAll() {
        try (SqlSession session = MY_BATIS.getSession();) {
            logger.info("Get all airline in SqlSession");
            return session.selectList("getAll");
        }
    }

    @Override
    public void setAirline(Airline airline, Airplane airplane) {
        try (SqlSession session = MY_BATIS.getSession()) {
            AirlineRepository airlineRepo = session.getMapper(AirlineRepository.class);
            airlineRepo.setAirline(airline, airplane);
            session.commit();
            logger.info("Airline linked to airplane");
        }
    }
}
