package com.laba.solvd.database.persistence.mapper;

import com.laba.solvd.database.config.MyBatis;
import com.laba.solvd.database.domain.Airplane;
import com.laba.solvd.database.domain.Package;
import com.laba.solvd.database.persistence.PackageRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class PackageMapperImpl implements PackageRepository {
    private static final Logger logger = LogManager.getLogger(PackageMapperImpl.class.getName());
    private static final MyBatis MY_BATIS = MyBatis.getInstance();

    @Override
    public void create(Package aPackage) {
        try (SqlSession session = MY_BATIS.getSession();){
            session.insert("create", aPackage);
            session.commit();
            logger.info("Package created in SqlSession");
        }
    }

    @Override
    public void update(Package aPackage) {
        try (SqlSession session = MY_BATIS.getSession();){
            session.update("update", aPackage);
            session.commit();
            logger.info("Package updated in SqlSession");
        }
    }

    @Override
    public void delete(Package aPackage) {
        try (SqlSession session = MY_BATIS.getSession();){
            session.delete("delete", aPackage);
            session.commit();
            logger.info("Package deleted in SqlSession");
        }
    }

    @Override
    public Package read(int id) {
        try (SqlSession session = MY_BATIS.getSession();){
            logger.info("Read package in SqlSession");
            return session.selectOne("read");
        }
    }

    @Override
    public List<Package> getAll() {
        try (SqlSession session = MY_BATIS.getSession();) {
            logger.info("Received all packages");
            return session.selectList("getAll");
        }
    }

    @Override
    public void setPackage(Package aPackage, Airplane airplane) {
        try (SqlSession session = MY_BATIS.getSession()) {
            PackageRepository packageRepo = session.getMapper(PackageRepository.class);
            packageRepo.setPackage(aPackage, airplane);
            session.commit();
            logger.info("Package linked to airplane");
        }
    }
}
