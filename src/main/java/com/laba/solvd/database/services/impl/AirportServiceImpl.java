package com.laba.solvd.database.services.impl;

import com.laba.solvd.database.domain.Airport;
import com.laba.solvd.database.domain.Route;
import com.laba.solvd.database.persistence.AirportRepository;
import com.laba.solvd.database.persistence.impl.AirportRepositoryImpl;
import com.laba.solvd.database.services.AirportService;

import java.util.List;
import java.util.stream.Collectors;

public class AirportServiceImpl implements AirportService {
    private final AirportRepository airportRepository;
    //private final RouteService routeService;

    public AirportServiceImpl() {
        airportRepository = new AirportRepositoryImpl();
        //routeService = new RouteServiceImpl();
    }

    @Override
    public Airport create(Airport airport) {
        airport.setId(null);

        if (airport.getRoutes() != null) {
            List<Route> routes = null;
            // create list of routes with RouteService
            airport.setRoutes(routes);
        }

        airportRepository.create(airport);
        return airport;
    }

    @Override
    public List<Airport> getAll() {
        return null;
    }
}
