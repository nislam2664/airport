package com.laba.solvd.database.services;

import com.laba.solvd.database.domain.Employee;

import java.util.List;

public interface EmployeeService {
    Employee create(Employee employee);
    List<Employee> getAll();
}
