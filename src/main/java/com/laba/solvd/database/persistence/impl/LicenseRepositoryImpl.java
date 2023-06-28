package com.laba.solvd.database.persistence.impl;

import com.laba.solvd.database.Main;
import com.laba.solvd.database.config.ConnectionPool;
import com.laba.solvd.database.domain.Employee;
import com.laba.solvd.database.domain.License;
import com.laba.solvd.database.persistence.LicenseRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LicenseRepositoryImpl implements LicenseRepository {
    private static final Logger logger = LogManager.getLogger(LicenseRepositoryImpl.class.getName());

    private String CREATE = "INSERT INTO licenses (certification_no, issued, expired) VALUES (?, ?, ?)";
    private String UPDATE = "UPDATE licenses SET certification_no = ?, issued = ?, expired = ? WHERE id = ?";
    private String DELETE = "DELETE FROM licenses WHERE id = ?";
    private String READ = "SELECT id, certification_no, issued, expired FROM licenses WHERE id = ?";
    private String GET_ALL = "SELECT id, certification_no, issued, expired FROM licenses";

    private String SET_LICENSE = "INSERT INTO licenses (id, employee_id) VALUES (?, ?)";

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(License license) {
        Connection connection = CONNECTION_POOL.getConnection();

        try (PreparedStatement ps = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, license.getCertificationNo());
            ps.setDate(2, Date.valueOf(license.getIssued()));
            ps.setDate(3, Date.valueOf(license.getExpired()));
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next())
                license.setId(rs.getInt(1));
        } catch (SQLException e) {
            logger.error("Unable to create license", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void update(License license) {
        Connection connection = CONNECTION_POOL.getConnection();

        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, license.getCertificationNo());
            ps.setDate(2, Date.valueOf(license.getIssued()));
            ps.setDate(3, Date.valueOf(license.getExpired()));
            ps.setInt(4, license.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.warn("Unable to update license", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void delete(License license) {
        Connection connection = CONNECTION_POOL.getConnection();

        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, license.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Unable to delete license", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public License read(int id) {
        Connection connection = CONNECTION_POOL.getConnection();
        License license = new License();

        try (PreparedStatement ps = connection.prepareStatement(READ)) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                license.setId(rs.getInt("id"));
                license.setCertificationNo(rs.getInt("certification_no"));
                license.setIssued(rs.getDate("issued").toLocalDate());
                license.setExpired(rs.getDate("expired").toLocalDate());
            }
        } catch (SQLException e) {
            logger.warn("Unable to read license", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

        return license;
    }

    @Override
    public List<License> getAll() {
        Connection connection = CONNECTION_POOL.getConnection();
        List<License> licenses = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(GET_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                License license = new License();
                license.setId(rs.getInt("id"));
                license.setCertificationNo(rs.getInt("certification_no"));
                license.setIssued(rs.getDate("issued").toLocalDate());
                license.setExpired(rs.getDate("expired").toLocalDate());
                licenses.add(license);
            }
        } catch (SQLException e) {
            logger.warn("Unable to obtain employees", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

        return licenses;
    }

    public void setLicense(License license, Employee employee) {
        Connection connection = CONNECTION_POOL.getConnection();

        try (PreparedStatement ps = connection.prepareStatement(SET_LICENSE, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, license.getId());
            ps.setInt(2, employee.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.warn("Unable to set license" , e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    public static License findById(Integer id, List<License> licenses) {
        return licenses.stream().filter(license -> license.getId().equals(id)).findFirst().orElseGet(() -> {
            License newLicense = new License();
            newLicense.setId(id);
            licenses.add(newLicense);
            return newLicense;
        });
    }

    public static License mapRow(ResultSet rs) throws SQLException {
        License license = new License();

        while (rs.next()) {
            license.setId(rs.getInt("id"));
            license.setCertificationNo(rs.getInt("certification_no"));
            license.setIssued(rs.getDate("issued").toLocalDate());
            license.setExpired(rs.getDate("expired").toLocalDate());
        }

        return license;
    }
}
