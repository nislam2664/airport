package com.laba.solvd.database.services;

import com.laba.solvd.database.domain.Airplane;

import java.util.List;

public interface AirplaneService {
    Airplane create(Airplane airplane);
    List<Airplane> getAll();
}
