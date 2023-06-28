package com.laba.solvd.database.persistence.mapper;

import com.laba.solvd.database.config.MyBatis;
import com.laba.solvd.database.domain.Employee;
import com.laba.solvd.database.domain.License;
import com.laba.solvd.database.persistence.LicenseRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class LicenseMapperImpl implements LicenseRepository {
    private static final Logger logger = LogManager.getLogger(LicenseMapperImpl.class.getName());
    private static final MyBatis MY_BATIS = MyBatis.getInstance();

    @Override
    public void create(License license) {
        try (SqlSession session = MY_BATIS.getSession();){
            session.insert("create", license);
            session.commit();
            logger.info("License created in SqlSession");
        }
    }

    @Override
    public void update(License license) {
        try (SqlSession session = MY_BATIS.getSession();){
            session.update("update", license);
            session.commit();
            logger.info("License updated in SqlSession");
        }
    }

    @Override
    public void delete(License license) {
        try (SqlSession session = MY_BATIS.getSession();){
            session.delete("delete", license);
            session.commit();
            logger.info("License deleted in SqlSession");
        }
    }

    @Override
    public License read(int id) {
        try (SqlSession session = MY_BATIS.getSession();){
            logger.info("Read license in SqlSession");
            return session.selectOne("read");
        }
    }

    @Override
    public List<License> getAll() {
        try (SqlSession session = MY_BATIS.getSession();) {
            logger.info("Received all licenses");
            return session.selectList("getAll");
        }
    }

    @Override
    public void setLicense(License license, Employee employee) {
        try (SqlSession session = MY_BATIS.getSession()) {
            LicenseRepository licenseRepo = session.getMapper(LicenseRepository.class);
            licenseRepo.setLicense(license, employee);
            session.commit();
            logger.info("License linked to employee");
        }
    }
}
