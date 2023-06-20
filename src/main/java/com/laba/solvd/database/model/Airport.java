package com.laba.solvd.database.model;

import java.util.List;
import java.util.Objects;

public class Airport {
    private int id;
    private String code;
    private String name;
    private float longitude;
    private float latitude;

    private List<Route> routes;

    public Airport() {

    }

    public Airport(int id, String code, String name, float longitude, float latitude, List<Route> routes) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.routes = routes;
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

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public List<Route> getRoutes() {
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

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return id == airport.id && Float.compare(airport.longitude, longitude) == 0 && Float.compare(airport.latitude, latitude) == 0 && Objects.equals(code, airport.code) && Objects.equals(name, airport.name) && Objects.equals(routes, airport.routes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, longitude, latitude, routes);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", routes=" + routes +
                '}';
    }
}
