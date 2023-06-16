package com.laba.solvd.database.model;

import java.util.Objects;

public class Package {
    private int id;
    private String name;
    private String address;
    private int airplaneId;

    public Package() {

    }

    public Package(int id, String name, String address, int airplaneId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.airplaneId = airplaneId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAirplaneId() {
        return airplaneId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package aPackage = (Package) o;
        return id == aPackage.id && airplaneId == aPackage.airplaneId && Objects.equals(name, aPackage.name) && Objects.equals(address, aPackage.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, airplaneId);
    }

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", airplaneId=" + airplaneId +
                '}';
    }
}
