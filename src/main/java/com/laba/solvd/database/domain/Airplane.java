package com.laba.solvd.database.domain;

import java.util.List;
import java.util.Objects;

public class Airplane {
    private int id;
    private Airline airline;
    private AirplaneType type;
    private int capacity;

    private List<Package> packages;
    private List<Employee> employees;
    private List<Flight> flights;

    public Airplane() {

    }

    public Airplane(int id, Airline airline, AirplaneType type, int capacity) {
        this.id = id;
        this.airline = airline;
        this.type = type;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public Airline getAirline() {
        return airline;
    }

    public AirplaneType getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Package> getPackages() {
        return packages;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public void setType(AirplaneType type) {
        this.type = type;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setPackages(List<Package> packages) {
        this.packages = packages;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airplane airplane = (Airplane) o;
        return id == airplane.id && capacity == airplane.capacity && Objects.equals(airline, airplane.airline) && Objects.equals(type, airplane.type) && Objects.equals(packages, airplane.packages) && Objects.equals(employees, airplane.employees) && Objects.equals(flights, airplane.flights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, airline, type, capacity, packages, employees, flights);
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "id=" + id +
                ", airline=" + airline +
                ", type=" + type +
                ", capacity=" + capacity +
                ", packages=" + packages +
                ", employees=" + employees +
                ", flights=" + flights +
                '}';
    }
}
