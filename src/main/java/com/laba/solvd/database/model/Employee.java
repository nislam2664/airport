package com.laba.solvd.database.model;

import java.util.Objects;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int airplaneId;

    public Employee() {

    }

    public Employee(int id, String firstName, String lastName, int airplaneId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.airplaneId = airplaneId;
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

    public int getAirplaneId() {
        return airplaneId;
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

    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && airplaneId == employee.airplaneId && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, airplaneId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", airplaneId=" + airplaneId +
                '}';
    }
}
