package com.laba.solvd.database.persistence;

import com.laba.solvd.database.domain.Employee;
import com.laba.solvd.database.domain.License;

public interface LicenseRepository extends DaoRepository<License> {
    void setLicense(License license, Employee employee);
}
