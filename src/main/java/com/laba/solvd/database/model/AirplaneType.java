package com.laba.solvd.database.model;

import java.util.ArrayList;
import java.util.Objects;

public class AirplaneType {
    private int id;
    private String brand;
    private String model;

    private final ArrayList<Airplane> airplanes = new ArrayList<>();

    public AirplaneType() {

    }

    public AirplaneType(int id, String brand, String model) {
        this.id = id;
        this.brand = brand;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public ArrayList<Airplane> getAirplanes() {
        return airplanes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirplaneType that = (AirplaneType) o;
        return id == that.id && Objects.equals(brand, that.brand) && Objects.equals(model, that.model) && Objects.equals(airplanes, that.airplanes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model, airplanes);
    }

    @Override
    public String toString() {
        return "AirplaneType{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", airplanes=" + airplanes +
                '}';
    }
}
