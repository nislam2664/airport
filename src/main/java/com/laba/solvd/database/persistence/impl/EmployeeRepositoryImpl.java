package com.laba.solvd.database.persistence.impl;

import com.laba.solvd.database.config.ConnectionPool;
import com.laba.solvd.database.domain.Employee;
import com.laba.solvd.database.persistence.DaoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements DaoRepository<Employee> {
    private static final Logger logger = LogManager.getLogger(EmployeeRepositoryImpl.class.getName());

    private String CREATE = "INSERT INTO employees (first_name, last_name) VALUES (?, ?, ?)";
    private String UPDATE = "UPDATE employees SET first_name = ?, last_name = ? WHERE id = ?";
    private String DELETE = "DELETE from employees WHERE id = ?";
    private String READ = "SELECT id, first_name, last_name FROM employees WHERE id = ?";
    private String GET_ALL = "SELECT id, first_name, last_name FROM employees";

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
        Employee employee = null;

        try (PreparedStatement ps = connection.prepareStatement(READ)) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int employeeId = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");

                employee = new Employee(employeeId, firstName, lastName);
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
}
