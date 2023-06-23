package com.laba.solvd.database.persistence;

import com.laba.solvd.database.domain.Airplane;
import com.laba.solvd.database.domain.Package;

public interface PackageRepository extends DaoRepository<Package> {
    void setPackage(Package aPackage, Airplane airplane);
}
