package com.laba.solvd.database.services.impl;

import com.laba.solvd.database.domain.Employee;
import com.laba.solvd.database.domain.License;
import com.laba.solvd.database.factory.ConnectionMethodFactory;
import com.laba.solvd.database.persistence.EmployeeRepository;
import com.laba.solvd.database.persistence.impl.AirplaneTypeRepositoryImpl;
import com.laba.solvd.database.persistence.impl.EmployeeRepositoryImpl;
import com.laba.solvd.database.persistence.mapper.AirplaneTypeMapperImpl;
import com.laba.solvd.database.persistence.mapper.EmployeeMapperImpl;
import com.laba.solvd.database.services.EmployeeService;
import com.laba.solvd.database.services.LicenseService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final LicenseService licenseService;

    public EmployeeServiceImpl() {
        if (ConnectionMethodFactory.isPool())
            this.employeeRepository = new EmployeeRepositoryImpl();
        else
            this.employeeRepository = new EmployeeMapperImpl();
        this.licenseService = new LicenseServiceImpl();
    }

    @Override
    public Employee create(Employee employee) {
        employee.setId(null);
        employeeRepository.create(employee);

        if (employee.getLicense() != null) {
            License license = licenseService.create(employee.getLicense());
            employee.setLicense(license);
        }

        return employee;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.getAll();
    }
}
