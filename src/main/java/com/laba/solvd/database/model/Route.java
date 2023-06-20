package com.laba.solvd.database.model;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

public class Route {
    private int id;
    private Airport fromAirport;
    private Airport toAirport;
    private LocalTime departure;
    private LocalTime arrival;

    private List<Flight> flights;

    public Route() {

    }

    public Route(int id, Airport fromAirport, Airport toAirport, LocalTime departure, LocalTime arrival, List<Flight> flights) {
        this.id = id;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.departure = departure;
        this.arrival = arrival;
        this.flights = flights;
    }

    public int getId() {
        return id;
    }

    public Airport getFromAirport() {
        return fromAirport;
    }

    public Airport getToAirport() {
        return toAirport;
    }

    public LocalTime getDeparture() {
        return departure;
    }

    public LocalTime getArrival() {
        return arrival;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFromAirport(Airport fromAirport) {
        this.fromAirport = fromAirport;
    }

    public void setToAirport(Airport toAirport) {
        this.toAirport = toAirport;
    }

    public void setDeparture(LocalTime departure) {
        this.departure = departure;
    }

    public void setArrival(LocalTime arrival) {
        this.arrival = arrival;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return id == route.id && Objects.equals(fromAirport, route.fromAirport) && Objects.equals(toAirport, route.toAirport) && Objects.equals(departure, route.departure) && Objects.equals(arrival, route.arrival) && Objects.equals(flights, route.flights);
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
