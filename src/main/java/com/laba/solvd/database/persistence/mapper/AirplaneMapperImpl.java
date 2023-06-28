package com.laba.solvd.database.persistence.mapper;

import com.laba.solvd.database.config.MyBatis;
import com.laba.solvd.database.domain.Airplane;
import com.laba.solvd.database.domain.Employee;
import com.laba.solvd.database.domain.Package;
import com.laba.solvd.database.persistence.AirplaneRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AirplaneMapperImpl implements AirplaneRepository {
    private static final MyBatis MY_BATIS = MyBatis.getInstance();

    @Override
    public void create(Airplane airplane) {
        try (SqlSession session = MY_BATIS.getSession();){
            session.insert("create", airplane);
            session.commit();
        }
    }

    @Override
    public void update(Airplane airplane) {
        try (SqlSession session = MY_BATIS.getSession();){
            session.update("update", airplane);
            session.commit();
        }
    }

    @Override
    public void delete(Airplane airplane) {
        try (SqlSession session = MY_BATIS.getSession();){
            session.delete("delete", airplane);
            session.commit();
        }
    }

    @Override
    public Airplane read(int id) {
        try (SqlSession session = MY_BATIS.getSession();){
            return session.selectOne("read");
        }
    }

    @Override
    public List<Airplane> getAll() {
        try (SqlSession session = MY_BATIS.getSession();) {
            return session.selectList("getAll");
        }
    }

    @Override
    public List<Package> getPackagesByAirplaneId(int id) {
        try (SqlSession session = MY_BATIS.getSession();) {
            return session.selectList("getPackagesByAirplaneId");
        }
    }

    @Override
    public List<Employee> getEmployeesByAirplaneId(int id) {
        try (SqlSession session = MY_BATIS.getSession();) {
            return session.selectList("getEmployeesByAirplaneId");
        }
    }

}
