package com.laba.solvd.database.persistence.impl;

import com.laba.solvd.database.Main;
import com.laba.solvd.database.config.ConnectionPool;
import com.laba.solvd.database.domain.Airline;
import com.laba.solvd.database.domain.Airplane;
import com.laba.solvd.database.persistence.AirlineRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirlineRepositoryImpl implements AirlineRepository {
    private static final Logger logger = LogManager.getLogger(AirlineRepositoryImpl.class.getName());

    private String CREATE = "INSERT INTO airlines (name, code) VALUES (?, ?)";
    private String UPDATE = "UPDATE airlines SET name = ?, code = ? WHERE id = ?";
    private String DELETE = "DELETE FROM airlines WHERE id = ?";
    private String READ = "SELECT id, name, code FROM airlines WHERE id = ?";
    private String GET_ALL = "SELECT id, name, code FROM airlines";

    private String SET_AIRLINE = "INSERT INTO airlines (id, airplane_id) VALUES (?, ?)";

    private final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(Airline airline) {
        Connection connection = CONNECTION_POOL.getConnection();

        try (PreparedStatement ps = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, airline.getName());
            ps.setString(2, airline.getCode());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next())
                airline.setId(rs.getInt(1));
        } catch (SQLException e) {
            logger.error("Unable to create airline", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void update(Airline airline) {
        Connection connection = CONNECTION_POOL.getConnection();

        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, airline.getName());
            ps.setString(2, airline.getCode());
            ps.setInt(3, airline.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.warn("Unable to update airline", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Airline airline) {
        Connection connection = CONNECTION_POOL.getConnection();

        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, airline.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Unable to delete airline", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public Airline read(int id) {
        Connection connection = CONNECTION_POOL.getConnection();
        Airline airline = new Airline();

        try (PreparedStatement ps = connection.prepareStatement(READ)) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                airline.setId(rs.getInt("id"));
                airline.setName(rs.getString("name"));
                airline.setCode(rs.getString("code"));
            }
        } catch (SQLException e) {
            logger.warn("Unable to read airline", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

        return airline;
    }

    @Override
    public List<Airline> getAll() {
        Connection connection = CONNECTION_POOL.getConnection();
        List<Airline> airlines = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(GET_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Airline airline = new Airline();
                airline.setId(rs.getInt("id"));
                airline.setName(rs.getString("name"));
                airline.setCode(rs.getString("code"));
                airlines.add(airline);
            }
        } catch (SQLException e) {
            logger.warn("Unable to obtain airlines", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

        return airlines;
    }

    @Override
    public void setAirline(Airline airline, Airplane airplane) {
        Connection connection = CONNECTION_POOL.getConnection();

        try (PreparedStatement ps = connection.prepareStatement(SET_AIRLINE, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, airline.getId());
            ps.setInt(2, airplane.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.warn("Unable to set airline" , e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    public static Airline findById(Integer id, List<Airline> airlines) {
        return airlines.stream().filter(airline -> airline.getId().equals(id)).findFirst().orElseGet(() -> {
            Airline newAirline = new Airline();
            newAirline.setId(id);
            airlines.add(newAirline);
            return newAirline;
        });
    }

    public static Airline mapRow(ResultSet rs) throws SQLException {
        Airline airline = new Airline();

        while (rs.next()) {
            airline.setId(rs.getInt("id"));
            airline.setName(rs.getString("name"));
            airline.setCode(rs.getString("code"));
        }

        return airline;
    }
}
