package com.laba.solvd.database.domain;

import java.util.Objects;

public class Passenger {
    private Integer id;
    private String firstName;
    private String lastName;
    private int passportNo;

    public Passenger() {

    }

    public Passenger(Integer id, String firstName, String lastName, int passportNo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportNo = passportNo;
    }

    public Integer getId() {
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

    public void setId(Integer id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger that = (Passenger) o;
        return passportNo == that.passportNo && Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, passportNo);
    }

    @Override
    public String toString() {
        return "Passengers{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passportNo=" + passportNo +
                '}';
    }
}
