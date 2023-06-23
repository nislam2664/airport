package com.laba.solvd.database.services;

import com.laba.solvd.database.domain.License;

import java.util.List;

public interface LicenseService {
    License create(License license);
    List<License> getAll();
}
