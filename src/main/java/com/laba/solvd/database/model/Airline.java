package com.laba.solvd.database.model;

import java.util.List;
import java.util.Objects;

public class Airline {
    private int id;
    private String code;
    private String name;

    private List<Airplane> airplanes;

    public Airline() {

    }

    public Airline(int id, String code, String name, List<Airplane> airplanes) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.airplanes = airplanes;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public List<Airplane> getAirplanes() {
        return airplanes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAirplanes(List<Airplane> airplanes) {
        this.airplanes = airplanes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline = (Airline) o;
        return id == airline.id && Objects.equals(code, airline.code) && Objects.equals(name, airline.name) && Objects.equals(airplanes, airline.airplanes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, airplanes);
    }

    @Override
    public String toString() {
        return "Airline{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", airplanes=" + airplanes +
                '}';
    }
}
