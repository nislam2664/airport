package com.laba.solvd.database.model;

import java.util.ArrayList;
import java.util.Objects;

public class Airplane {
    private int id;
    private int airlineId;
    private int typeId;
    private int capacity;

    private final ArrayList<Package> packages = new ArrayList<>();
    private final ArrayList<Employee> employees = new ArrayList<>();
    private final ArrayList<Flight> flights = new ArrayList<>();

    public Airplane() {

    }

    public Airplane(int id, int airlineId, int typeId, int capacity) {
        this.id = id;
        this.airlineId = airlineId;
        this.typeId = typeId;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public int getAirlineId() {
        return airlineId;
    }

    public int getTypeId() {
        return typeId;
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<Package> getPackages() {
        return packages;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airplane airplane = (Airplane) o;
        return id == airplane.id && airlineId == airplane.airlineId && typeId == airplane.typeId && capacity == airplane.capacity && Objects.equals(packages, airplane.packages) && Objects.equals(employees, airplane.employees) && Objects.equals(flights, airplane.flights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, airlineId, typeId, capacity, packages, employees, flights);
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "id=" + id +
                ", airlineId=" + airlineId +
                ", typeId=" + typeId +
                ", capacity=" + capacity +
                ", packages=" + packages +
                ", employees=" + employees +
                ", flights=" + flights +
                '}';
    }
}
