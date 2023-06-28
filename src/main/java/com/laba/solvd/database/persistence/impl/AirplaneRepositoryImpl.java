package com.laba.solvd.database.persistence.impl;

import com.laba.solvd.database.Main;
import com.laba.solvd.database.config.ConnectionPool;
import com.laba.solvd.database.domain.Airplane;
import com.laba.solvd.database.domain.Employee;
import com.laba.solvd.database.domain.Package;
import com.laba.solvd.database.persistence.AirplaneRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirplaneRepositoryImpl implements AirplaneRepository {
    private static final Logger logger = LogManager.getLogger(AirlineRepositoryImpl.class.getName());

    private String CREATE = "INSERT INTO airplanes (capacity) VALUES (?)";
    private String UPDATE = "UPDATE airplanes SET capacity = ? WHERE id = ?";
    private String DELETE = "DELETE FROM airplanes WHERE id = ?";
    private String READ = "SELECT id, capacity FROM airplanes WHERE id = ?";
    private String GET_ALL = "SELECT airplanes.id, airlines.id, airlines.name, airlines.code, airplane_types.id, " +
                             "airplane_types.brand, airplane_types.model, airplanes.capacity, employees.id, employees.first_name," +
                             "employees.last_name, packages.id, packages.name, packages.address FROM airplanes " +
                             "LEFT JOIN airlines ON airline.airplane_id = airplanes.id " +
                             "LEFT JOIN airplane_types ON airplane_types.airplane_id = airplanes.id " +
                             "LEFT JOIN employees ON employees.airplane_id = airplanes.id " +
                             "LEFT JOIN packages ON packages.airplane_id = airplanes.id";

    private String JOIN_PACKAGES = "SELECT packages.id, packages.name, packages.address FROM airplanes LEFT JOIN packages ON packages.airplane_id = airplanes.id WHERE airplanes.id = ?";
    private String JOIN_EMPLOYEES = "SELECT employees.id, employees.first_name, employees.last_name FROM airplanes LEFT JOIN employees ON employees.airplane_id = airplanes.id WHERE airplanes.id = ?";;

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(Airplane airplane) {
        Connection connection = CONNECTION_POOL.getConnection();

        try (PreparedStatement ps = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, airplane.getCapacity());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next())
                airplane.setId(rs.getInt(1));
        } catch (SQLException e) {
            logger.error("Unable to create airplane", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void update(Airplane airplane) {
        Connection connection = CONNECTION_POOL.getConnection();

        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, airplane.getCapacity());
            ps.setInt(3, airplane.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.warn("Unable to update airplane", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Airplane airplane) {
        Connection connection = CONNECTION_POOL.getConnection();

        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, airplane.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Unable to delete airplane", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public Airplane read(int id) {
        Connection connection = CONNECTION_POOL.getConnection();
        Airplane airplane = new Airplane();

        try (PreparedStatement ps = connection.prepareStatement(READ)) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                airplane.setId(rs.getInt("id"));
                airplane.setCapacity(rs.getInt("capacity"));
            }
        } catch (SQLException e) {
            logger.warn("Unable to read airplane", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

        return airplane;
    }

    @Override
    public List<Airplane> getAll() {
        Connection connection = CONNECTION_POOL.getConnection();
        List<Airplane> airplanes = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(GET_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Airplane airplane = new Airplane();
                airplane.setId(rs.getInt("id"));
                airplane.setCapacity(rs.getInt("capacity"));
                airplanes.add(airplane);
            }
        } catch (SQLException e) {
            logger.warn("Unable to obtain airplanes", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

        return airplanes;
    }

    @Override
    public List<Package> getPackagesByAirplaneId(int id) {
        Connection connection = CONNECTION_POOL.getConnection();
        List<Package> packages = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(JOIN_PACKAGES)) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Package aPackage = new Package();
                aPackage.setId(rs.getInt("id"));
                aPackage.setName(rs.getString("name"));
                aPackage.setAddress(rs.getString("address"));
                packages.add(aPackage);
            }
        } catch (SQLException e) {
            logger.warn("Unable to find packages by airplane ID: " + id , e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

        return packages;
    }


    public List<Employee> getEmployeesByAirplaneId(int id) {
        Connection connection = CONNECTION_POOL.getConnection();
        List<Employee> employees = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(JOIN_EMPLOYEES)) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            logger.warn("Unable to find employees by airplane ID: " + id , e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

        return employees;
    }

    public static Airplane findById(Integer id, List<Airplane> airplanes) {
        return airplanes.stream().filter(airplane -> airplane.getId().equals(id)).findFirst().orElseGet(() -> {
            Airplane newAirplane = new Airplane();
            newAirplane.setId(id);
            airplanes.add(newAirplane);
            return newAirplane;
        });
    }

    public static List<Airplane> mapRow(ResultSet rs, List<Airplane> airplanes) throws SQLException {
        if (airplanes == null)
            airplanes = new ArrayList<>();

        while (rs.next()) {
            Integer id = rs.getInt("id");
            Airplane airplane = findById(id, airplanes);

            airplane.setAirline(AirlineRepositoryImpl.mapRow(rs));
            airplane.setType(AirplaneTypeRepositoryImpl.mapRow(rs));
            airplane.setCapacity(rs.getInt("capacity"));
            airplane.setPackages(PackageRepositoryImpl.mapRow(rs, airplane.getPackages()));
            airplane.setEmployees(EmployeeRepositoryImpl.mapRow(rs, airplane.getEmployees()));
            airplanes.add(airplane);
        }

        return airplanes;
    }
}
