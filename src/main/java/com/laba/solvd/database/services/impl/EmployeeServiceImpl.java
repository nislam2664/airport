package com.laba.solvd.database.services.impl;

import com.laba.solvd.database.domain.Employee;
import com.laba.solvd.database.domain.License;
import com.laba.solvd.database.persistence.EmployeeRepository;
import com.laba.solvd.database.persistence.LicenseRepository;
import com.laba.solvd.database.persistence.impl.EmployeeRepositoryImpl;
import com.laba.solvd.database.persistence.impl.LicenseRepositoryImpl;
import com.laba.solvd.database.services.EmployeeService;
import com.laba.solvd.database.services.LicenseService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final LicenseRepository licenseRepository;
    private final LicenseService licenseService;

    public EmployeeServiceImpl() {
        this.employeeRepository = new EmployeeRepositoryImpl();
        this.licenseRepository = new LicenseRepositoryImpl();
        this.licenseService = new LicenseServiceImpl();
    }

    @Override
    public Employee create(Employee employee) {
        employee.setId(null);
        employeeRepository.create(employee);

        if (employee.getLicense() != null) {
            License license = licenseService.create(employee.getLicense());
            licenseRepository.setLicense(license, employee);
        }

        return employee;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.getAll();
    }
}