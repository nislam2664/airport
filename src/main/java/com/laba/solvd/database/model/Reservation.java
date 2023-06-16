package com.laba.solvd.database.model;

import java.util.ArrayList;
import java.util.Objects;

public class Reservation {
    private int id;
    private int flightNo;
    private String seatNo;
    private float price;

    private final ArrayList<Passenger> passengers = new ArrayList<>();

    public Reservation() {

    }

    public Reservation(int id, int flightNo, String seatNo, float price) {
        this.id = id;
        this.flightNo = flightNo;
        this.seatNo = seatNo;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getFlightNo() {
        return flightNo;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public float getPrice() {
        return price;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFlightNo(int flightNo) {
        this.flightNo = flightNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return id == that.id && flightNo == that.flightNo && Float.compare(that.price, price) == 0 && Objects.equals(seatNo, that.seatNo) && Objects.equals(passengers, that.passengers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flightNo, seatNo, price, passengers);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", flightNo=" + flightNo +
                ", seatNo='" + seatNo + '\'' +
                ", price=" + price +
                ", passengers=" + passengers +
                '}';
    }
}
