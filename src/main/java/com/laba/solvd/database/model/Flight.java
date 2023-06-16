package com.laba.solvd.database.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Flight {
    private int id;
    private int routeId;
    private int airplaneId;
    private LocalDate dateLog;
    private String flightStatus;

    private final ArrayList<Reservation> reservations = new ArrayList<>();

    public Flight() {

    }

    public Flight(int id, int routeId, int airplaneId, LocalDate dateLog, String flightStatus) {
        this.id = id;
        this.routeId = routeId;
        this.airplaneId = airplaneId;
        this.dateLog = dateLog;
        this.flightStatus = flightStatus;
    }

    public int getId() {
        return id;
    }

    public int getRouteId() {
        return routeId;
    }

    public int getAirplaneId() {
        return airplaneId;
    }

    public LocalDate getDateLog() {
        return dateLog;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
    }

    public void setDateLog(LocalDate dateLog) {
        this.dateLog = dateLog;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return id == flight.id && routeId == flight.routeId && airplaneId == flight.airplaneId && Objects.equals(dateLog, flight.dateLog) && Objects.equals(flightStatus, flight.flightStatus) && Objects.equals(reservations, flight.reservations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, routeId, airplaneId, dateLog, flightStatus, reservations);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", routeId=" + routeId +
                ", airplaneId=" + airplaneId +
                ", dateLog=" + dateLog +
                ", flightStatus='" + flightStatus + '\'' +
                ", reservations=" + reservations +
                '}';
    }
}
