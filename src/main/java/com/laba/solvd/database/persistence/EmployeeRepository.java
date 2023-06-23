package com.laba.solvd.database.persistence;

import com.laba.solvd.database.domain.Airplane;
import com.laba.solvd.database.domain.Employee;

public interface EmployeeRepository extends DaoRepository<Employee> {
    void setEmployee(Employee employee, Airplane airplane);
}
