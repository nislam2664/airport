package com.laba.solvd.database.persistence.impl;

import com.laba.solvd.database.Main;
import com.laba.solvd.database.config.ConnectionPool;
import com.laba.solvd.database.domain.Airplane;
import com.laba.solvd.database.domain.Employee;
import com.laba.solvd.database.persistence.EmployeeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private static final Logger logger = LogManager.getLogger(EmployeeRepositoryImpl.class.getName());

    private String CREATE = "INSERT INTO employees (first_name, last_name) VALUES (?, ?)";
    private String UPDATE = "UPDATE employees SET first_name = ?, last_name = ? WHERE id = ?";
    private String DELETE = "DELETE from employees WHERE id = ?";
    private String READ = "SELECT id, first_name, last_name FROM employees WHERE id = ?";
    private String GET_ALL = "SELECT employees.id, employees.first_name, employees.last_name, licenses.id, " +
                             "licenses.certification_no, licenses.issued, licenses.expired FROM employees " +
                             "LEFT JOIN licenses ON employees.id = licenses.employee_id";

    private String SET_EMPLOYEE = "INSERT INTO employees (id, airplane_id) VALUES (?, ?)";

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(Employee employee) {
        Connection connection = CONNECTION_POOL.getConnection();

        try (PreparedStatement ps = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next())
                employee.setId(rs.getInt(1));
        } catch (SQLException e) {
            logger.error("Unable to create employee", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void update(Employee employee) {
        Connection connection = CONNECTION_POOL.getConnection();

        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setInt(3, employee.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.warn("Unable to update employee", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Employee employee) {
        Connection connection = CONNECTION_POOL.getConnection();

        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, employee.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Unable to delete employee", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public Employee read(int id) {
        Connection connection = CONNECTION_POOL.getConnection();
        Employee employee = new Employee();

        try (PreparedStatement ps = connection.prepareStatement(READ)) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                employee.setId(rs.getInt("id"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
            }
        } catch (SQLException e) {
            logger.warn("Unable to read employee", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

        return employee;
    }

    @Override
    public List<Employee> getAll() {
        Connection connection = CONNECTION_POOL.getConnection();
        List<Employee> employees = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(GET_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            logger.warn("Unable to obtain employees", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

        return employees;
    }

    @Override
    public void setEmployee(Employee employee, Airplane airplane) {
        Connection connection = CONNECTION_POOL.getConnection();

        try (PreparedStatement ps = connection.prepareStatement(SET_EMPLOYEE, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, employee.getId());
            ps.setInt(2, airplane.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.warn("Unable to set employee" , e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    public static Employee findById(Integer id, List<Employee> employees) {
        return employees.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElseGet(() -> {
            Employee newEmployee = new Employee();
            newEmployee.setId(id);
            employees.add(newEmployee);
            return newEmployee;
        });
    }

    public static List<Employee> mapRow(ResultSet rs, List<Employee> employees) throws SQLException {
        if (employees == null)
            employees = new ArrayList<>();

        while (rs.next()) {
            Integer id = rs.getInt("id");
            Employee employee = findById(id, employees);

            employee.setFirstName(rs.getString("first_name"));
            employee.setLastName(rs.getString("last_name"));
            employee.setLicense(LicenseRepositoryImpl.mapRow(rs));
            employees.add(employee);
        }

        return employees;
    }
}
