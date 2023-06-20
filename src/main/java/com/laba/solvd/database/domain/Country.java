package com.laba.solvd.database.domain;

import java.util.List;
import java.util.Objects;

public class Country {
    private int id;
    private String code;
    private String name;

    private List<Airport> airports;

    public Country() {

    }

    public Country(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
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

    public List<Airport> getAirports() {
        return airports;
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

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return id == country.id && Objects.equals(code, country.code) && Objects.equals(name, country.name) && Objects.equals(airports, country.airports);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, airports);
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", airports=" + airports +
                '}';
    }
}
