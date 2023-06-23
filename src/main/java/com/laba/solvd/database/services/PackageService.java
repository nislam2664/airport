package com.laba.solvd.database.services;

import com.laba.solvd.database.domain.Package;

import java.util.List;

public interface PackageService {
    Package create(Package aPackage);
    List<Package> getAll();
}
