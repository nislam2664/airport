package com.laba.solvd.database.persistence;

import com.laba.solvd.database.domain.Airport;
import com.laba.solvd.database.domain.Route;

import java.util.List;

public interface AirportRepository extends DaoRepository<Airport> {
    List<Route> getRoutesByAirportId(int id);
}
