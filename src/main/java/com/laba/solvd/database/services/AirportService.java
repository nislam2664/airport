package com.laba.solvd.database.services;

import com.laba.solvd.database.domain.Airport;

import java.util.List;

public interface AirportService {
    Airport create(Airport airport);
    List<Airport> getAll();
}
