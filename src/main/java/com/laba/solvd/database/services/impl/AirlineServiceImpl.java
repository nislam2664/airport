package com.laba.solvd.database.services.impl;

import com.laba.solvd.database.domain.Airline;
import com.laba.solvd.database.persistence.AirlineRepository;
import com.laba.solvd.database.persistence.impl.AirlineRepositoryImpl;
import com.laba.solvd.database.services.AirlineService;

import java.util.List;

public class AirlineServiceImpl implements AirlineService {
    private final AirlineRepository airlineRepository;

    public AirlineServiceImpl() {
        this.airlineRepository = new AirlineRepositoryImpl();
    }

    @Override
    public Airline create(Airline airline) {
        airline.setId(null);
        airlineRepository.create(airline);
        return airline;
    }

    @Override
    public List<Airline> getAll() {
        return airlineRepository.getAll();
    }
}
