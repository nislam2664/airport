package com.laba.solvd.database.interfaces;

import com.laba.solvd.database.model.Airport;
import com.laba.solvd.database.model.Route;

import java.util.List;

public interface AirportDao extends Dao<Airport> {
    List<Route> getRoutesById(int id);
}
