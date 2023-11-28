package com.example.demo.models;


import jakarta.persistence.*;

@Entity
public class Tours {
    @Id
    @SequenceGenerator(name = "pet_seq", sequenceName = "pet_sequence1", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "pet_seq")

    private Long tour_id;

    private String start_date, end_date, destination, tour_price;

    public Tours() {
    }

    public Tours(Long tour_id, String start_date, String end_date, String destination, String tour_price) {
        this.tour_id = tour_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.destination = destination;
        this.tour_price = tour_price;
    }

    public Tours(String start_date, String end_date, String destination, String tour_price) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.destination = destination;
        this.tour_price = tour_price;
    }

    public Long getTour_id() {
        return tour_id;
    }

    public void setTour_id(Long tour_id) {
        this.tour_id = tour_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTour_price() {
        return tour_price;
    }

    public void setTour_price(String tour_price) {
        this.tour_price = tour_price;
    }
}
