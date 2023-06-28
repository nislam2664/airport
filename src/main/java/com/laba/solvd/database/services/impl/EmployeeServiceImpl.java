package com.laba.solvd.database.services.impl;

import com.laba.solvd.database.domain.Employee;
import com.laba.solvd.database.domain.License;
import com.laba.solvd.database.persistence.EmployeeRepository;
import com.laba.solvd.database.persistence.impl.AirlineRepositoryImpl;
import com.laba.solvd.database.persistence.impl.EmployeeRepositoryImpl;
import com.laba.solvd.database.persistence.mapper.AirlineMapperImpl;
import com.laba.solvd.database.persistence.mapper.EmployeeMapperImpl;
import com.laba.solvd.database.services.EmployeeService;
import com.laba.solvd.database.services.LicenseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static com.laba.solvd.database.Main.connectionFactory;

public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger logger = LogManager.getLogger(EmployeeServiceImpl.class.getName());
    private final EmployeeRepository employeeRepository;
    private final LicenseService licenseService;

    public EmployeeServiceImpl() {
        if (!connectionFactory.isMyBatis()) {
            this.employeeRepository = new EmployeeRepositoryImpl();
            logger.info("Using JDBC Employee repository");
        }
        else {
            this.employeeRepository = new EmployeeRepositoryImpl();
            logger.info("Using MyBatis Employee mapper");
        }
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
