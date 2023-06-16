package com.laba.solvd.database.model;

import java.util.ArrayList;
import java.util.Objects;

public class Airport {
    private int id;
    private String code;
    private String name;
    private int country;
    private float longitude;
    private float latitude;

    private final ArrayList<Route> routes = new ArrayList<>();

    public Airport() {

    }

    public Airport(int id, String code, String name, int country, float longitude, float latitude) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.country = country;
        this.longitude = longitude;
        this.latitude = latitude;
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

    public int getCountry() {
        return country;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public ArrayList<Route> getRoutes() {
        return routes;
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

    public void setCountry(int country) {
        this.country = country;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return id == airport.id && country == airport.country && Float.compare(airport.longitude, longitude) == 0 && Float.compare(airport.latitude, latitude) == 0 && Objects.equals(code, airport.code) && Objects.equals(name, airport.name) && Objects.equals(routes, airport.routes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, country, longitude, latitude, routes);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", country=" + country +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", routes=" + routes +
                '}';
    }
}
