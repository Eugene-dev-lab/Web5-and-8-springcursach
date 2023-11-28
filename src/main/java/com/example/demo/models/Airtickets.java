package com.example.demo.models;

import jakarta.persistence.*;

@Entity
public class Airtickets {

    @Id
    @SequenceGenerator(name = "pet_seq", sequenceName = "pet_sequence1", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "pet_seq")

    private Long ticket_id;

    private String departure_date, arrival_date, flight_number,departure_location, destination;
    private float ticket_price;

    public Airtickets() {
    }
    public Airtickets(Long ticket_id, String departure_date, String arrival_date, String flight_number, String departure_location, String destination, float ticket_price) {
        this.ticket_id = ticket_id;
        this.departure_date = departure_date;
        this.arrival_date = arrival_date;
        this.flight_number = flight_number;
        this.departure_location = departure_location;
        this.destination = destination;
        this.ticket_price = ticket_price;
    }

    public Airtickets(String departure_date, String arrival_date, String flight_number, String departure_location, String destination, float ticket_price) {
        this.departure_date = departure_date;
        this.arrival_date = arrival_date;
        this.flight_number = flight_number;
        this.departure_location = departure_location;
        this.destination = destination;
        this.ticket_price = ticket_price;
    }

    public Long getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(Long ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }

    public String getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(String arrival_date) {
        this.arrival_date = arrival_date;
    }

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }

    public String getDeparture_location() {
        return departure_location;
    }

    public void setDeparture_location(String departure_location) {
        this.departure_location = departure_location;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public float getTicket_price() {
        return ticket_price;
    }

    public void setTicket_price(float ticket_price) {
        this.ticket_price = ticket_price;
    }
}
