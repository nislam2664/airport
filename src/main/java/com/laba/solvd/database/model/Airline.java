package com.laba.solvd.database.model;

import java.util.ArrayList;
import java.util.Objects;

public class Airline {
    private int id;
    private String name;
    private String code;

    private final ArrayList<Airplane> airplanes = new ArrayList<>();

    public Airline() {

    }

    public Airline(int id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public ArrayList<Airplane> getAirplanes() {
        return airplanes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline = (Airline) o;
        return id == airline.id && Objects.equals(name, airline.name) && Objects.equals(code, airline.code) && Objects.equals(airplanes, airline.airplanes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, airplanes);
    }

    @Override
    public String toString() {
        return "Airline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", airplanes=" + airplanes +
                '}';
    }
}
