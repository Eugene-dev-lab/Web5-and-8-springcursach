package com.example.demo.models;


import jakarta.persistence.*;

@Entity
public class Clients {
    @Id
    @SequenceGenerator(name = "pet_seq", sequenceName = "pet_sequence1", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "pet_seq")

    private Long client_id;

    private String first_name, last_name, address, phone_number, email;


    public Clients() {
    }

    public Clients(Long client_id, String first_name, String last_name, String address, String phone_number, String email) {
        this.client_id = client_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.phone_number = phone_number;
        this.email = email;
    }

    public Clients(String first_name, String last_name, String address, String phone_number, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.phone_number = phone_number;
        this.email = email;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
