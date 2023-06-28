package com.laba.solvd.database.persistence.mapper;

import com.laba.solvd.database.config.MyBatis;
import com.laba.solvd.database.domain.Airline;
import com.laba.solvd.database.domain.Airplane;
import com.laba.solvd.database.persistence.AirlineRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AirlineMapperImpl implements AirlineRepository {
    private static final MyBatis MY_BATIS = MyBatis.getInstance();

    @Override
    public void create(Airline airline) {
        try (SqlSession session = MY_BATIS.getSession();){
            session.insert("create", airline);
            session.commit();
        }
    }

    @Override
    public void update(Airline airline) {
        try (SqlSession session = MY_BATIS.getSession();){
            session.update("update", airline);
            session.commit();
        }
    }

    @Override
    public void delete(Airline airline) {
        try (SqlSession session = MY_BATIS.getSession();){
            session.delete("delete", airline);
            session.commit();
        }
    }

    @Override
    public Airline read(int id) {
        try (SqlSession session = MY_BATIS.getSession();){
            return session.selectOne("read");
        }
    }

    @Override
    public List<Airline> getAll() {
        try (SqlSession session = MY_BATIS.getSession();) {
            return session.selectList("getAll");
        }
    }

    @Override
    public void setAirline(Airline airline, Airplane airplane) {
        try (SqlSession session = MY_BATIS.getSession()) {
            AirlineRepository airlineRepo = session.getMapper(AirlineRepository.class);
            airlineRepo.setAirline(airline, airplane);
            session.commit();
        }
    }
}
