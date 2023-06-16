package com.laba.solvd.database.model;

import java.util.Objects;

public class Passenger {
    private int id;
    private String firstName;
    private String lastName;
    private int passportNo;
    private int confirmationNo;

    public Passenger() {

    }

    public Passenger(int id, String firstName, String lastName, int passportNo, int confirmationNo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportNo = passportNo;
        this.confirmationNo = confirmationNo;
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

    public int getConfirmationNo() {
        return confirmationNo;
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

    public void setConfirmationNo(int confirmationNo) {
        this.confirmationNo = confirmationNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return id == passenger.id && passportNo == passenger.passportNo && confirmationNo == passenger.confirmationNo && Objects.equals(firstName, passenger.firstName) && Objects.equals(lastName, passenger.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, passportNo, confirmationNo);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passportNo=" + passportNo +
                ", confirmationNo=" + confirmationNo +
                '}';
    }
}
