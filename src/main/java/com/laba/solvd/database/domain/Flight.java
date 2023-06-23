package com.laba.solvd.database.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Flight {
    private Integer id;
    private Airplane airplane;
    private LocalDate date;
    private String status;

    private List<Reservation> reservations;

    public Flight() {

    }

    public Flight(Integer id, Airplane airplane, LocalDate date, String status) {
        this.id = id;
        this.airplane = airplane;
        this.date = date;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(id, flight.id) && Objects.equals(airplane, flight.airplane) && Objects.equals(date, flight.date) && Objects.equals(status, flight.status) && Objects.equals(reservations, flight.reservations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, airplane, date, status, reservations);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", airplane=" + airplane +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", reservations=" + reservations +
                '}';
    }
}
