package com.laba.solvd.database.persistence.impl;

import com.laba.solvd.database.config.ConnectionPool;
import com.laba.solvd.database.domain.AirplaneType;
import com.laba.solvd.database.persistence.DaoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirplaneTypeRepositoryImpl implements DaoRepository<AirplaneType> {
    private static final Logger logger = LogManager.getLogger(AirplaneTypeRepositoryImpl.class.getName());

    private String CREATE = "INSERT INTO airplane_types (brand, model) VALUES (?, ?)";
    private String UPDATE = "UPDATE airplane_types SET brand = ?, model = ? WHERE id = ?";
    private String DELETE = "DELETE FROM airplane_types WHERE id = ?";
    private String READ = "SELECT id, brand, model FROM airplane_types WHERE id = ?";
    private String GET_ALL = "SELECT id, brand, model FROM airplane_types";

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();


    @Override
    public void create(AirplaneType airplaneType) {
        Connection connection = CONNECTION_POOL.getConnection();

        try (PreparedStatement ps = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, airplaneType.getBrand());
            ps.setString(2, airplaneType.getModel());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next())
                airplaneType.setId(rs.getInt(1));
        } catch (SQLException e) {
            logger.error("Unable to create airplane type", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void update(AirplaneType airplaneType) {
        Connection connection = CONNECTION_POOL.getConnection();

        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, airplaneType.getBrand());
            ps.setString(2, airplaneType.getModel());
            ps.setInt(3, airplaneType.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.warn("Unable to update airplane type", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void delete(AirplaneType airplaneType) {
        Connection connection = CONNECTION_POOL.getConnection();

        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, airplaneType.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Unable to delete airplane type", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public AirplaneType read(int id) {
        Connection connection = CONNECTION_POOL.getConnection();
        AirplaneType airplaneType = new AirplaneType();

        try (PreparedStatement ps = connection.prepareStatement(READ)) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                airplaneType.setId(rs.getInt("id"));
                airplaneType.setBrand(rs.getString("brand"));
                airplaneType.setModel(rs.getString("model"));
            }
        } catch (SQLException e) {
            logger.warn("Unable to read airplane type", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

        return airplaneType;
    }

    @Override
    public List<AirplaneType> getAll() {
        Connection connection = CONNECTION_POOL.getConnection();
        List<AirplaneType> airplaneTypes = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(GET_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AirplaneType airplaneType = new AirplaneType();
                airplaneType.setId(rs.getInt("id"));
                airplaneType.setBrand(rs.getString("brand"));
                airplaneType.setModel(rs.getString("model"));
                airplaneTypes.add(airplaneType);
            }
        } catch (SQLException e) {
            logger.warn("Unable to obtain airplane types", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

        return airplaneTypes;
    }

    public static AirplaneType findById(Integer id, List<AirplaneType> airplaneTypes) {
        return airplaneTypes.stream().filter(airplaneType -> airplaneType.getId().equals(id)).findFirst().orElseGet(() -> {
            AirplaneType newAirplaneType = new AirplaneType();
            newAirplaneType.setId(id);
            airplaneTypes.add(newAirplaneType);
            return newAirplaneType;
        });
    }

    public static AirplaneType mapRow(ResultSet rs) throws SQLException {
        AirplaneType airplaneType = new AirplaneType();

        while (rs.next()) {
            airplaneType.setId(rs.getInt("id"));
            airplaneType.setBrand(rs.getString("brand"));
            airplaneType.setModel(rs.getString("model"));
        }

        return airplaneType;
    }
}
