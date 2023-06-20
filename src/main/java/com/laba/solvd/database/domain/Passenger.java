package com.laba.solvd.database.domain;

import java.util.Objects;

public class Passenger {
    private int id;
    private String firstName;
    private String lastName;
    private int passportNo;
    private Reservation reservation;

    public Passenger() {

    }

    public Passenger(int id, String firstName, String lastName, int passportNo, Reservation reservation) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportNo = passportNo;
        this.reservation = reservation;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPassportNo() {
        return passportNo;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassportNo(int passportNo) {
        this.passportNo = passportNo;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return id == passenger.id && passportNo == passenger.passportNo && Objects.equals(firstName, passenger.firstName) && Objects.equals(lastName, passenger.lastName) && Objects.equals(reservation, passenger.reservation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, passportNo, reservation);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passportNo=" + passportNo +
                ", reservation=" + reservation +
                '}';
    }
}

