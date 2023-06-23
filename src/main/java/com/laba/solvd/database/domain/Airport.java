package com.laba.solvd.database.domain;

import java.util.Objects;

public class Airport {
    private Integer id;
    private String name;
    private String code;
    private float longitude;
    private float latitude;

    public Airport() {

    }

    public Airport(Integer id, String name, String code, float longitude, float latitude) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
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
        return Float.compare(airport.longitude, longitude) == 0 && Float.compare(airport.latitude, latitude) == 0 && Objects.equals(id, airport.id) && Objects.equals(name, airport.name)  && Objects.equals(code, airport.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, longitude, latitude);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
