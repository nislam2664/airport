package com.laba.solvd.database.domain;

import java.util.Objects;

public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private License license;

    public Employee() {

    }

    public Employee(Integer id, String firstName, String lastName, License license) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.license = license;
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

    public License getLicense() {
        return license;
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

    public void setLicense(License license) {
        this.license = license;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(license, employee.license);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, license);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", license=" + license + '\'' +
                '}';
    }
}
