package com.laba.solvd.database.services.impl;

import com.laba.solvd.database.domain.Package;
import com.laba.solvd.database.persistence.PackageRepository;
import com.laba.solvd.database.persistence.impl.PackageRepositoryImpl;
import com.laba.solvd.database.services.PackageService;

import java.util.List;

public class PackageServiceImpl implements PackageService {
    private final PackageRepository packageRepository;

    public PackageServiceImpl() {
        this.packageRepository = new PackageRepositoryImpl();
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
