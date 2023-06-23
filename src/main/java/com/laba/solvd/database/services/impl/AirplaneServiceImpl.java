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
    private final AirlineRepository airlineRepository;
    private final AirlineService airlineService;
    private final AirplaneTypeRepository airplaneTypeRepository;
    private final AirplaneTypeService airplaneTypeService;
    private final PackageRepository packageRepository;
    private final PackageService packageService;
    private final EmployeeRepository employeeRepository;
    private final EmployeeService employeeService;

    public AirplaneServiceImpl() {
        this.airplaneRepository = new AirplaneRepositoryImpl();
        this.airlineRepository = new AirlineRepositoryImpl();
        this.airlineService = new AirlineServiceImpl();
        this.airplaneTypeRepository = new AirplaneTypeRepositoryImpl();
        this.airplaneTypeService = new AirplaneTypeServiceImpl();
        this.packageRepository = new PackageRepositoryImpl();
        this.packageService = new PackageServiceImpl();
        this.employeeRepository = new EmployeeRepositoryImpl();
        this.employeeService = new EmployeeServiceImpl();
    }

    @Override
    public Airplane create(Airplane airplane) {

        airplane.setId(null);
        airplaneRepository.create(airplane);

        if (airplane.getAirline() != null) {
            Airline airline = airlineService.create(airplane.getAirline());
            airlineRepository.setAirline(airline, airplane);
        }

        if (airplane.getType() != null) {
            AirplaneType airplaneType = airplaneTypeService.create(airplane.getType());
            airplaneTypeRepository.setAirplaneType(airplaneType, airplane);
        }

        if (airplane.getPackages() != null) {
            List<Package> packages = airplane.getPackages().stream().map(packageService::create).collect(Collectors.toList());
            packages.forEach(aPackage -> { packageRepository.setPackage(aPackage, airplane); });
        }

        if (airplane.getEmployees() != null) {
            List<Employee> employees = airplane.getEmployees().stream().map(employeeService::create).collect(Collectors.toList());
            employees.forEach(employee -> { employeeRepository.setEmployee(employee, airplane); });
        }

        return airplane;
    }

    @Override
    public List<Airplane> getAll() {
        return airplaneRepository.getAll();
    }
}
