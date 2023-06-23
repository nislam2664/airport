package com.laba.solvd.database;

import com.laba.solvd.database.domain.*;
import com.laba.solvd.database.domain.Package;
import com.laba.solvd.database.services.AirplaneService;
import com.laba.solvd.database.services.impl.AirplaneServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {

        Airplane airplane = new Airplane();
        logger.warn("Empty Airplane object created");
        AirplaneService airplaneService = new AirplaneServiceImpl();
        logger.info("Airplane service created");

        Airline airline = new Airline();
        logger.warn("Empty Airline object created");
        airline.setName("Alsie Express");
        logger.info("Airline name set");
        airline.setCode("MMD");
        logger.info("Airline code set");

        AirplaneType airplaneType = new AirplaneType();
        logger.warn("Empty AirplaneType object created");
        airplaneType.setBrand("ATR");
        logger.info("Airplane brand set");
        airplaneType.setModel("ATR-72-500");
        logger.info("Airplane model set");

        License license1 = new License();
        logger.warn("Empty License object created");
        license1.setCertificationNo(20813264);
        logger.info("Certification number set");
        license1.setIssued(LocalDate.parse("1998-10-24"));
        logger.info("Issued date set");
        license1.setExpired(LocalDate.parse("2026-10-24"));
        logger.info("Expired date set");

        License license2 = new License();
        logger.warn("Empty License object created");
        license2.setCertificationNo(21135691);
        logger.info("Certification number set");
        license2.setIssued(LocalDate.parse("1998-05-11"));
        logger.info("Issued date set");
        license2.setExpired(LocalDate.parse("2026-05-11"));
        logger.info("Expired date set");

        Employee employee1 = new Employee();
        logger.warn("Empty Employee object created");
        employee1.setFirstName("Will");
        logger.info("First name set");
        employee1.setLastName("Graham");
        logger.info("Last name set");
        employee1.setLicense(license1);
        logger.info("License set");

        Employee employee2 = new Employee();
        logger.warn("Empty Employee object created");
        employee2.setFirstName("Alana");
        logger.info("First name set");
        employee2.setLastName("Bloom");
        logger.info("Last name set");
        employee2.setLicense(license2);
        logger.info("License set");

        Package package1 = new Package();
        logger.warn("Empty Package object created");
        package1.setName("Hannibal Lecter");
        logger.info("Name set");
        package1.setAddress("217 N Charles St, Baltimore, MD 21201");
        logger.info("Address set");

        airplane.setAirline(airline);
        logger.info("Airline set");
        airplane.setType(airplaneType);
        logger.info("AirplaneType set");
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        airplane.setEmployees(employees);
        logger.info("Employees set");
        List<Package> packages = new ArrayList<>();
        packages.add(package1);
        airplane.setPackages(packages);
        logger.info("Packages set");

        logger.debug(airplaneService.create(airplane));
    }
}
