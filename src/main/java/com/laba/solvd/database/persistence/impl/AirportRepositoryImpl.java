package com.laba.solvd.database.persistence.impl;

import com.laba.solvd.database.config.ConnectionPool;
import com.laba.solvd.database.domain.Airport;
import com.laba.solvd.database.domain.Employee;
import com.laba.solvd.database.domain.Route;
import com.laba.solvd.database.persistence.AirportRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class AirportRepositoryImpl implements AirportRepository {
    private static final Logger logger = LogManager.getLogger(AirportRepositoryImpl.class.getName());

    private String CREATE = "INSERT INTO airports (code, name, longitude, latitude) VALUES (?, ?, ?, ?)";
    private String UPDATE = "UPDATE airports SET code = ?, name = ?, longitude = ?, latitude = ? WHERE id = ?";
    private String DELETE = "DELETE from airports WHERE id = ?";
    private String READ = "SELECT id, code, name, longitude, latitude FROM airports WHERE id = ?";
    private String GET_ALL = "SELECT id, code, name, longitude, latitude FROM airports";

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(Airport airport) {
        Connection connection = CONNECTION_POOL.getConnection();

        try (PreparedStatement ps = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, airport.getCode());
            ps.setString(2, airport.getName());
            ps.setFloat(3, airport.getLongitude());
            ps.setFloat(4, airport.getLatitude());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next())
                airport.setId(rs.getInt(1));
        } catch (SQLException e) {
            logger.error("Unable to create airport", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void update(Airport airport) {
        Connection connection = CONNECTION_POOL.getConnection();

        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, airport.getCode());
            ps.setString(2, airport.getName());
            ps.setFloat(3, airport.getLongitude());
            ps.setFloat(4, airport.getLatitude());
            ps.setInt(5, airport.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.warn("Unable to update airport", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Airport airport) {
        Connection connection = CONNECTION_POOL.getConnection();

        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, airport.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Unable to delete airport", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public Airport read(int id) {
        Connection connection = CONNECTION_POOL.getConnection();
        Airport airport = null;

        try (PreparedStatement ps = connection.prepareStatement(READ)) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int airportId = rs.getInt("id");
                String code = rs.getString("code");
                String name = rs.getString("name");
                float longitude = rs. getFloat("longitude");
                float latitude = rs.getFloat("latitude");

                airport = new Airport(airportId, code, name, longitude, latitude);
            }
        } catch (SQLException e) {
            logger.warn("Unable to read airport", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

        return airport;
    }

    @Override
    public List<Airport> getAll() {
        Connection connection = CONNECTION_POOL.getConnection();
        List<Airport> airports = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(GET_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Airport airport = new Airport();
                airport.setId(rs.getInt("id"));
                airport.setCode(rs.getString("code"));
                airport.setName(rs.getString("name"));
                airport.setLongitude(rs.getFloat("longitude"));
                airport.setLatitude(rs.getFloat("latitude"));
                airports.add(airport);
            }
        } catch (SQLException e) {
            logger.warn("Unable to obtain airports", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

        return airports;
    }

    @Override
    public List<Route> getRoutesByAirportId(int id) {
        Connection connection = CONNECTION_POOL.getConnection();
        List<Route> routes = new ArrayList<>();

        String GET_ROUTES = "SELECT routes.id, routes.from_airport, routes.to_airport, routes.departure, routes.arrival FROM airports LEFT JOIN routes ON airports.id = routes.from_airport WHERE airports.id = ?";

        try (PreparedStatement ps = connection.prepareStatement(GET_ROUTES)) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Route route = new Route();
                route.setId(rs.getInt("id"));
                // Airport fromAirport = AirportServiceImpl.create();
                // Airport toAirport = AirportServiceImpl.create();
                route.setDeparture(rs.getDate("departure").toInstant().atZone(ZoneId.systemDefault()).toLocalTime());
                route.setArrival(rs.getDate("arrival").toInstant().atZone(ZoneId.systemDefault()).toLocalTime());
                routes.add(route);
            }
        } catch (SQLException e) {
            logger.warn("Unable to obtain routes for airport ID # :" + id, e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

        return routes;
    }
}
