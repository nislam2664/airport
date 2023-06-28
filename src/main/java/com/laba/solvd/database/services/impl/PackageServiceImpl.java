package com.laba.solvd.database.services.impl;

import com.laba.solvd.database.domain.Package;
import com.laba.solvd.database.factory.ConnectionMethodFactory;
import com.laba.solvd.database.persistence.PackageRepository;
import com.laba.solvd.database.persistence.impl.AirlineRepositoryImpl;
import com.laba.solvd.database.persistence.impl.LicenseRepositoryImpl;
import com.laba.solvd.database.persistence.impl.PackageRepositoryImpl;
import com.laba.solvd.database.persistence.mapper.AirlineMapperImpl;
import com.laba.solvd.database.persistence.mapper.LicenseMapperImpl;
import com.laba.solvd.database.persistence.mapper.PackageMapperImpl;
import com.laba.solvd.database.services.PackageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static com.laba.solvd.database.Main.connectionFactory;

public class PackageServiceImpl implements PackageService {
    private static final Logger logger = LogManager.getLogger(PackageServiceImpl.class.getName());
    private final PackageRepository packageRepository;

    public PackageServiceImpl() {
        if (!connectionFactory.isMyBatis()) {
            this.packageRepository = new PackageRepositoryImpl();
            logger.info("Using JDBC Package repository");
        }
        else {
            this.packageRepository = new PackageMapperImpl();
            logger.info("Using MyBatis Package mapper");
        }
    }

    @Override
    public Package create(Package aPackage) {
        aPackage.setId(null);
        packageRepository.create(aPackage);
        return aPackage;
    }

    @Override
    public List<Package> getAll() {
        return packageRepository.getAll();
    }
}
