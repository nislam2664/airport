package com.laba.solvd.database.services.impl;

import com.laba.solvd.database.domain.*;
import com.laba.solvd.database.domain.Package;
import com.laba.solvd.database.persistence.*;
import com.laba.solvd.database.persistence.impl.*;
import com.laba.solvd.database.services.*;

import java.util.List;
import java.util.stream.Collectors;

public class AirplaneServiceImpl implements AirplaneService {
    private final AirplaneRepository airplaneRepository;
    private final AirlineService airlineService;
    private final AirplaneTypeService airplaneTypeService;
    private final PackageService packageService;
    private final EmployeeService employeeService;

    public AirplaneServiceImpl() {
        this.airplaneRepository = new AirplaneRepositoryImpl();
        this.airlineService = new AirlineServiceImpl();
        this.airplaneTypeService = new AirplaneTypeServiceImpl();
        this.packageService = new PackageServiceImpl();
        this.employeeService = new EmployeeServiceImpl();
    }

    @Override
    public Airplane create(Airplane airplane) {
        airplane.setId(null);
        airplaneRepository.create(airplane);

        if (airplane.getAirline() != null) {
            Airline airline = airlineService.create(airplane.getAirline());
            airplane.setAirline(airline);
        }

        if (airplane.getType() != null) {
            AirplaneType airplaneType = airplaneTypeService.create(airplane.getType());
            airplane.setType(airplaneType);
        }

        if (airplane.getPackages() != null) {
            List<Package> packages = airplane.getPackages().stream().map(packageService::create).collect(Collectors.toList());
            airplane.setPackages(packages);
        }

        if (airplane.getEmployees() != null) {
            List<Employee> employees = airplane.getEmployees().stream().map(employeeService::create).collect(Collectors.toList());
            airplane.setEmployees(employees);
        }

        return airplane;
    }

    @Override
    public List<Airplane> getAll() {
        return airplaneRepository.getAll();
    }
}
