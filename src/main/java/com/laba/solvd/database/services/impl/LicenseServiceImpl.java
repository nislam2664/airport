package com.laba.solvd.database.services.impl;

import com.laba.solvd.database.domain.License;
import com.laba.solvd.database.persistence.LicenseRepository;
import com.laba.solvd.database.persistence.impl.LicenseRepositoryImpl;
import com.laba.solvd.database.services.LicenseService;

import java.util.List;

public class LicenseServiceImpl implements LicenseService {
    private final LicenseRepository licenseRepository;

    public LicenseServiceImpl() {
        this.licenseRepository = new LicenseRepositoryImpl();
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
