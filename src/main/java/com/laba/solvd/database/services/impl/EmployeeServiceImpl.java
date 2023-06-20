package com.laba.solvd.database.services.impl;

import com.laba.solvd.database.domain.Employee;
import com.laba.solvd.database.persistence.DaoRepository;;
import com.laba.solvd.database.persistence.impl.EmployeeRepositoryImpl;
import com.laba.solvd.database.services.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private final DaoRepository<Employee> employeeRepository;

    public EmployeeServiceImpl() {
        employeeRepository = new EmployeeRepositoryImpl();
    }

    @Override
    public Employee create(Employee employee) {
        employee.setId(null);
        employeeRepository.create(employee);
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.getAll();
    }
}
