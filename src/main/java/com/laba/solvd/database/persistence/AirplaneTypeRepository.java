package com.laba.solvd.database.persistence;

import com.laba.solvd.database.domain.Airplane;
import com.laba.solvd.database.domain.AirplaneType;

public interface AirplaneTypeRepository extends DaoRepository<AirplaneType> {
    void setAirplaneType(AirplaneType airplaneType, Airplane airplane);
}
