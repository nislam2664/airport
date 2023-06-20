package com.laba.solvd.database.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Flight {
    private int id;
    private Route route;
    private Airplane airplane;
    private LocalDate dateLog;
    private String flightStatus;

    private List<Reservation> reservations;

    public Flight() {

    }

    public Flight(int id, Route route, Airplane airplane, LocalDate dateLog, String flightStatus, List<Reservation> reservations) {
        this.id = id;
        this.route = route;
        this.airplane = airplane;
        this.dateLog = dateLog;
        this.flightStatus = flightStatus;
        this.reservations = reservations;
    }

    public int getId() {
        return id;
    }

    public Route getRoute() {
        return route;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public LocalDate getDateLog() {
        return dateLog;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public void setDateLog(LocalDate dateLog) {
        this.dateLog = dateLog;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return id == flight.id && Objects.equals(route, flight.route) && Objects.equals(airplane, flight.airplane) && Objects.equals(dateLog, flight.dateLog) && Objects.equals(flightStatus, flight.flightStatus) && Objects.equals(reservations, flight.reservations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, route, airplane, dateLog, flightStatus, reservations);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", route=" + route +
                ", airplane=" + airplane +
                ", dateLog=" + dateLog +
                ", flightStatus='" + flightStatus + '\'' +
                ", reservations=" + reservations +
                '}';
    }
}
