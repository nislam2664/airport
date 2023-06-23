package com.laba.solvd.database.services;

import com.laba.solvd.database.domain.AirplaneType;

import java.util.List;

public interface AirplaneTypeService {
    AirplaneType create(AirplaneType airplaneType);
    List<AirplaneType> getAll();
}
