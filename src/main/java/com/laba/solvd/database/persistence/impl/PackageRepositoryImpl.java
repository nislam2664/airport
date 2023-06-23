package com.laba.solvd.database.persistence.impl;

import com.laba.solvd.database.config.ConnectionPool;
import com.laba.solvd.database.persistence.DaoRepository;
import com.laba.solvd.database.domain.Package;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PackageRepositoryImpl implements DaoRepository<Package> {
    private static final Logger logger = LogManager.getLogger(PackageRepositoryImpl.class.getName());

    private String CREATE = "INSERT INTO packages (name, address) VALUES (?, ?)";
    private String UPDATE = "UPDATE packages SET name = ?, address = ? WHERE id = ?";
    private String DELETE = "DELETE FROM packages WHERE id = ?";
    private String READ = "SELECT id, name, address FROM packages WHERE id = ?";
    private String GET_ALL = "SELECT id, name, address FROM packages";

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(Package aPackage) {
        Connection connection = CONNECTION_POOL.getConnection();

        try (PreparedStatement ps = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, aPackage.getName());
            ps.setString(2, aPackage.getAddress());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next())
                aPackage.setId(rs.getInt(1));
        } catch (SQLException e) {
            logger.error("Unable to create package", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void update(Package aPackage) {
        Connection connection = CONNECTION_POOL.getConnection();

        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, aPackage.getName());
            ps.setString(2, aPackage.getAddress());
            ps.setInt(3, aPackage.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.warn("Unable to update package", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Package aPackage) {
        Connection connection = CONNECTION_POOL.getConnection();

        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, aPackage.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Unable to delete package", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public Package read(int id) {
        Connection connection = CONNECTION_POOL.getConnection();
        Package aPackage = new Package();

        try (PreparedStatement ps = connection.prepareStatement(READ)) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                aPackage.setId(rs.getInt("id"));
                aPackage.setName(rs.getString("name"));
                aPackage.setAddress(rs.getString("address"));
            }
        } catch (SQLException e) {
            logger.warn("Unable to read package", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

        return aPackage;
    }

    @Override
    public List<Package> getAll() {
        Connection connection = CONNECTION_POOL.getConnection();
        List<Package> packages = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(GET_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Package aPackage = new Package();
                aPackage.setId(rs.getInt("id"));
                aPackage.setName(rs.getString("name"));
                aPackage.setAddress(rs.getString("address"));
                packages.add(aPackage);
            }
        } catch (SQLException e) {
            logger.warn("Unable to obtain packages", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

        return packages;
    }

    public static Package findById(Integer id, List<Package> packages) {
        return packages.stream().filter(aPackage -> aPackage.getId().equals(id)).findFirst().orElseGet(() -> {
            Package newPackage = new Package();
            newPackage.setId(id);
            packages.add(newPackage);
            return newPackage;
        });
    }

    public static List<Package> mapRow(ResultSet rs, List<Package> packages) throws SQLException {
        if (packages == null)
            packages = new ArrayList<>();

        while (rs.next()) {
            Integer id = rs.getInt("id");
            Package aPackage = findById(id, packages);

            aPackage.setName(rs.getString("name"));
            aPackage.setAddress(rs.getString("address"));
            packages.add(aPackage);
        }

        return packages;
    }
}
