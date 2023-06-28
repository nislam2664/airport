package com.laba.solvd.database.persistence.mapper;

import com.laba.solvd.database.config.MyBatis;
import com.laba.solvd.database.domain.Airplane;
import com.laba.solvd.database.domain.Package;
import com.laba.solvd.database.persistence.AirlineRepository;
import com.laba.solvd.database.persistence.PackageRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PackageMapperImpl implements PackageRepository {
    private static final MyBatis MY_BATIS = MyBatis.getInstance();

    @Override
    public void create(Package aPackage) {
        try (SqlSession session = MY_BATIS.getSession();){
            session.insert("create", aPackage);
            session.commit();
        }
    }

    @Override
    public void update(Package aPackage) {
        try (SqlSession session = MY_BATIS.getSession();){
            session.update("update", aPackage);
            session.commit();
        }
    }

    @Override
    public void delete(Package aPackage) {
        try (SqlSession session = MY_BATIS.getSession();){
            session.delete("delete", aPackage);
            session.commit();
        }
    }

    @Override
    public Package read(int id) {
        try (SqlSession session = MY_BATIS.getSession();){
            return session.selectOne("read");
        }
    }

    @Override
    public List<Package> getAll() {
        try (SqlSession session = MY_BATIS.getSession();) {
            return session.selectList("getAll");
        }
    }

    @Override
    public void setPackage(Package aPackage, Airplane airplane) {
        try (SqlSession session = MY_BATIS.getSession()) {
            PackageRepository packageRepo = session.getMapper(PackageRepository.class);
            packageRepo.setPackage(aPackage, airplane);
            session.commit();
        }
    }
}
