package com.laba.solvd.database.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

public class Route {
    private int id;
    private int fromAirport;
    private int toAirport;
    private LocalTime departure;
    private LocalTime arrival;

    private final ArrayList<Flight> flights = new ArrayList<>();

    public Route() {

    }

    public Route(int id, int fromAirport, int toAirport, LocalTime departure, LocalTime arrival) {
        this.id = id;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.departure = departure;
        this.arrival = arrival;
    }

    public int getId() {
        return id;
    }

    public int getFromAirport() {
        return fromAirport;
    }

    public int getToAirport() {
        return toAirport;
    }

    public LocalTime getDeparture() {
        return departure;
    }

    public LocalTime getArrival() {
        return arrival;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFromAirport(int fromAirport) {
        this.fromAirport = fromAirport;
    }

    public void setToAirport(int toAirport) {
        this.toAirport = toAirport;
    }

    public void setDeparture(LocalTime departure) {
        this.departure = departure;
    }

    public void setArrival(LocalTime arrival) {
        this.arrival = arrival;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return id == route.id && fromAirport == route.fromAirport && toAirport == route.toAirport && Objects.equals(departure, route.departure) && Objects.equals(arrival, route.arrival) && Objects.equals(flights, route.flights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fromAirport, toAirport, departure, arrival, flights);
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", fromAirport=" + fromAirport +
                ", toAirport=" + toAirport +
                ", departure=" + departure +
                ", arrival=" + arrival +
                ", flights=" + flights +
                '}';
    }
}
