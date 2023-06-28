package com.laba.solvd.database.services.impl;

import com.laba.solvd.database.domain.License;
import com.laba.solvd.database.factory.ConnectionMethodFactory;
import com.laba.solvd.database.persistence.LicenseRepository;
import com.laba.solvd.database.persistence.impl.AirlineRepositoryImpl;
import com.laba.solvd.database.persistence.impl.EmployeeRepositoryImpl;
import com.laba.solvd.database.persistence.impl.LicenseRepositoryImpl;
import com.laba.solvd.database.persistence.mapper.AirlineMapperImpl;
import com.laba.solvd.database.persistence.mapper.EmployeeMapperImpl;
import com.laba.solvd.database.persistence.mapper.LicenseMapperImpl;
import com.laba.solvd.database.services.LicenseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static com.laba.solvd.database.Main.connectionFactory;

public class LicenseServiceImpl implements LicenseService {
    private static final Logger logger = LogManager.getLogger(LicenseServiceImpl.class.getName());
    private final LicenseRepository licenseRepository;

    public LicenseServiceImpl() {
        if (!connectionFactory.isMyBatis()) {
            this.licenseRepository = new LicenseRepositoryImpl();
            logger.info("Using JDBC License repository");
        }
        else {
            this.licenseRepository = new LicenseMapperImpl();
            logger.info("Using MyBatis License mapper");
        }
    }

    @Override
    public License create(License license) {
        license.setId(null);
        licenseRepository.create(license);
        return license;
    }

    @Override
    public List<License> getAll() {
        return licenseRepository.getAll();
    }
}
