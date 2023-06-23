package com.laba.solvd.database.persistence;

import com.laba.solvd.database.domain.Airplane;
import com.laba.solvd.database.domain.Employee;
import com.laba.solvd.database.domain.Package;

import java.util.List;

public interface AirplaneRepository extends DaoRepository<Airplane> {
    List<Package> getPackagesByAirplaneId(int id);
    List<Employee> getEmployeesByAirplaneId(int id);
}
