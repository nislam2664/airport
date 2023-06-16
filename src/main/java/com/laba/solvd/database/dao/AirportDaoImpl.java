package com.laba.solvd.database.dao;

import com.laba.solvd.database.config.ConnectionPool;
import com.laba.solvd.database.interfaces.AirportDao;
import com.laba.solvd.database.model.Airport;
import com.laba.solvd.database.model.Route;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirportDaoImpl implements AirportDao {
    private String CREATE = "INSERT INTO airports (id, code, name, country, longitude, latitude) VALUES (?, ?, ?, ?, ?, ?)";
    private String READ = "SELECT * FROM airports WHERE id = ?";
    private String UPDATE = "UPDATE airports SET code = ?, name = ?, country = ?, longitude = ?, latitude = ? WHERE id = ?";
    private String DELETE = "DELETE FROM airports WHERE id = ?";
    private String GET_ALL = "SELECT * FROM airports";

    ConnectionPool connectionPool;

    public AirportDaoImpl() {
        connectionPool = ConnectionPool.getInstance();
    }

    @Override
    public void create(Airport airport) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, airport.getId());
            ps.setString(2, airport.getCode());
            ps.setString(3, airport.getName());
            ps.setInt(4, airport.getCountry());
            ps.setFloat(5, airport.getLongitude());
            ps.setFloat(6, airport.getLatitude());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Airport airport) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, airport.getCode());
            ps.setString(2, airport.getName());
            ps.setInt(3, airport.getCountry());
            ps.setFloat(4, airport.getLongitude());
            ps.setFloat(5, airport.getLatitude());
            ps.setInt(6, airport.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Airport airport) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, airport.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Airport read(int id) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(READ)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                Airport airport = new Airport();

                airport.setId(rs.getInt("id"));
                airport.setName(rs.getString("name"));
                airport.setCode(rs.getString("code"));
                airport.setCountry(rs.getInt("country"));
                airport.setLongitude(rs.getFloat("longitude"));
                airport.setLongitude(rs.getFloat("latitude"));

                rs.close();
                return airport;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Airport> getAll() {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(GET_ALL);
             ResultSet rs = ps.executeQuery()) {
            List<Airport> airports = new ArrayList<>();

            while(rs.next()) {
                Airport airport = new Airport();
                airport.setId(rs.getInt("id"));
                airport.setName(rs.getString("name"));
                airport.setCode(rs.getString("code"));
                airport.setCountry(rs.getInt("country"));
                airport.setLongitude(rs.getFloat("longitude"));
                airport.setLongitude(rs.getFloat("latitude"));
                airports.add(airport);
            }

            return airports;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Route> getRoutesById(int id) {
        String GET_ROUTES = "SELECT route.id, from_airport, to_airport, departure, arrival FROM airports LEFT JOIN routes ON airports.route_id = routes.id WHERE airports.id = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(GET_ROUTES)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<Route> routes = new ArrayList<>();

            while(rs.next()) {
                Route route = new Route();
                route.setId(rs.getInt("id"));
                route.setFromAirport(rs.getInt("from_airport"));
                route.setToAirport(rs.getInt("to_airport"));
                route.setDeparture(rs.getTime("departure").toLocalTime());
                route.setArrival(rs.getTime("arrival").toLocalTime());
                routes.add(route);
            }

            rs.close();
            return routes;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
