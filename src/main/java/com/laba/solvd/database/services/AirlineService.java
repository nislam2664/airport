package com.laba.solvd.database.services;

import com.laba.solvd.database.domain.Airline;

import java.util.List;

public interface AirlineService {
    Airline create(Airline airline);
    List<Airline> getAll();
}
