package com.laba.solvd.database.domain;

import java.util.List;
import java.util.Objects;

public class Reservation {
    private int id;
    private Flight flight;
    private String seatNo;
    private float price;

    private List<Passenger> passengers;

    public Reservation() {

    }

    public Reservation(int id, Flight flight, String seatNo, float price) {
        this.id = id;
        this.flight = flight;
        this.seatNo = seatNo;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public Flight getFlight() {
        return flight;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public float getPrice() {
        return price;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return id == that.id && Float.compare(that.price, price) == 0 && Objects.equals(flight, that.flight) && Objects.equals(seatNo, that.seatNo) && Objects.equals(passengers, that.passengers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flight, seatNo, price, passengers);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", flight=" + flight +
                ", seatNo='" + seatNo + '\'' +
                ", price=" + price +
                ", passengers=" + passengers +
                '}';
    }
}
