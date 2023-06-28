package com.laba.solvd.database.persistence.mapper;

import com.laba.solvd.database.config.MyBatis;
import com.laba.solvd.database.domain.Airplane;
import com.laba.solvd.database.domain.AirplaneType;
import com.laba.solvd.database.persistence.AirplaneTypeRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AirplaneTypeMapperImpl implements AirplaneTypeRepository {
    private static final MyBatis MY_BATIS = MyBatis.getInstance();

    @Override
    public void create(AirplaneType airplaneType) {
        try (SqlSession session = MY_BATIS.getSession();){
            session.insert("create", airplaneType);
            session.commit();
        }
    }

    @Override
    public void update(AirplaneType airplaneType) {
        try (SqlSession session = MY_BATIS.getSession();){
            session.update("update", airplaneType);
            session.commit();
        }
    }

    @Override
    public void delete(AirplaneType airplaneType) {
        try (SqlSession session = MY_BATIS.getSession();){
            session.delete("delete", airplaneType);
            session.commit();
        }
    }

    @Override
    public AirplaneType read(int id) {
        try (SqlSession session = MY_BATIS.getSession();){
            return session.selectOne("read");
        }
    }

    @Override
    public List<AirplaneType> getAll() {
        try (SqlSession session = MY_BATIS.getSession();) {
            return session.selectList("getAll");
        }
    }

    @Override
    public void setAirplaneType(AirplaneType airplaneType, Airplane airplane) {
        try (SqlSession session = MY_BATIS.getSession()) {
            AirplaneTypeRepository typeRepo = session.getMapper(AirplaneTypeRepository.class);
            typeRepo.setAirplaneType(airplaneType, airplane);
            session.commit();
        }
    }
}
