package com.laba.solvd.database.services.impl;

import com.laba.solvd.database.domain.*;
import com.laba.solvd.database.domain.Package;
import com.laba.solvd.database.factory.ConnectionMethodFactory;
import com.laba.solvd.database.persistence.*;
import com.laba.solvd.database.persistence.impl.*;
import com.laba.solvd.database.persistence.mapper.AirlineMapperImpl;
import com.laba.solvd.database.persistence.mapper.AirplaneMapperImpl;
import com.laba.solvd.database.services.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

import static com.laba.solvd.database.Main.connectionFactory;

public class AirplaneServiceImpl implements AirplaneService {
    private static final Logger logger = LogManager.getLogger(AirplaneServiceImpl.class.getName());

    private final AirplaneRepository airplaneRepository;
    private final AirlineService airlineService;
    private final AirplaneTypeService airplaneTypeService;
    private final PackageService packageService;
    private final EmployeeService employeeService;

    public AirplaneServiceImpl() {
        if (!connectionFactory.isMyBatis()) {
            this.airplaneRepository = new AirplaneRepositoryImpl();
            logger.info("Using JDBC Airplane repository");
        }
        else {
            this.airplaneRepository = new AirplaneMapperImpl();
            logger.info("Using MyBatis Airplane mapper");
        }

        this.airlineService = new AirlineServiceImpl();
        this.airplaneTypeService = new AirplaneTypeServiceImpl();
        this.packageService = new PackageServiceImpl();
        this.employeeService = new EmployeeServiceImpl();
    }

    @Override
    public Airplane create(Airplane airplane) {
        airplane.setId(null);

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

        airplaneRepository.create(airplane);

        return airplane;
    }

    @Override
    public List<Airplane> getAll() {
        return airplaneRepository.getAll();
    }
}
