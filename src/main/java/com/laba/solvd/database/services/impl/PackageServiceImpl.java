package com.laba.solvd.database.services.impl;

import com.laba.solvd.database.domain.Package;
import com.laba.solvd.database.factory.ConnectionMethodFactory;
import com.laba.solvd.database.persistence.PackageRepository;
import com.laba.solvd.database.persistence.impl.LicenseRepositoryImpl;
import com.laba.solvd.database.persistence.impl.PackageRepositoryImpl;
import com.laba.solvd.database.persistence.mapper.LicenseMapperImpl;
import com.laba.solvd.database.persistence.mapper.PackageMapperImpl;
import com.laba.solvd.database.services.PackageService;

import java.util.List;

public class PackageServiceImpl implements PackageService {
    private final PackageRepository packageRepository;

    public PackageServiceImpl() {
        if (ConnectionMethodFactory.isPool())
            this.packageRepository = new PackageRepositoryImpl();
        else
            this.packageRepository = new PackageMapperImpl();
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
