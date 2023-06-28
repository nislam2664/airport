package com.laba.solvd.database.persistence;

import com.laba.solvd.database.domain.Airline;
import com.laba.solvd.database.domain.Airplane;

public interface AirlineRepository extends DaoRepository<Airline> {
    void setAirline(Airline airline, Airplane airplane);
}
