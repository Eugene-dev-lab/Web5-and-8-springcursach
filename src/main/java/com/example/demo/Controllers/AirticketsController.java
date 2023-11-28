package com.example.demo.Controllers;

import org.springframework.ui.Model;
import com.example.demo.models.Airtickets;
import com.example.demo.repo.AirticketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class AirticketsController {
    @Autowired
    private AirticketsRepository AirticketsRepository;
    @GetMapping("/tickets")
    public String Main(Model model) {
        Iterable<Airtickets> tickets = AirticketsRepository.findAll();
        model.addAttribute("tickets", tickets);
        return "tickets-main";
    }

    @GetMapping("/tickets/add")
    public String Add(Model model) {
        return "tickets-add";
    }

    @PostMapping("/tickets/add")
    public String AirticketsAdd(@RequestParam String departure_date, @RequestParam String arrival_date, @RequestParam String flight_number, @RequestParam String departure_location, @RequestParam String destination, @RequestParam float ticket_price, Model model) {
        Airtickets airtickets = new Airtickets(departure_date, arrival_date, flight_number, departure_location, destination, ticket_price);
        AirticketsRepository.save(airtickets);
            return "redirect:/tickets";
    }

    @GetMapping("/tickets/{id}")
    public String Details(@PathVariable(value = "id" ) long id, Model model) {
        if (!AirticketsRepository.existsById(id)) {
            return "redirect:/tickets";
        }
       Optional<Airtickets> airtickets = AirticketsRepository.findById(id);
        ArrayList<Airtickets> tickets = new ArrayList<>();
        airtickets.ifPresent(tickets::add);
       model.addAttribute("airtickets", tickets);
        return "tickets-details";
    }

    @GetMapping("/tickets/{id}/edit")
    public String blogEdit(@PathVariable(value = "id" ) long id, Model model) {
        if (!AirticketsRepository.existsById(id)) {
            return "redirect:/tickets";
        }
        Optional<Airtickets> airtickets = AirticketsRepository.findById(id);
        ArrayList<Airtickets> tickets = new ArrayList<>();
        airtickets.ifPresent(tickets::add);
        model.addAttribute("airtickets", tickets);
        return "tickets-edit";
    }

    @PostMapping("/tickets/{id}/edit")
    public String AirticketsUpdate(@PathVariable("id") Long id,@RequestParam String departure_date, @RequestParam String arrival_date, @RequestParam String flight_number, @RequestParam String departure_location, @RequestParam String destination, @RequestParam float ticket_price, Model model) {
       Airtickets airtickets = AirticketsRepository.findById(id).orElseThrow();
        airtickets.setDeparture_date(departure_date);
        airtickets.setArrival_date(arrival_date);
        airtickets.setFlight_number(flight_number);
        airtickets.setDeparture_location(departure_location);
        airtickets.setDestination(destination);
        airtickets.setTicket_price(ticket_price);
        AirticketsRepository.save(airtickets);
        return "redirect:/tickets";
    }


    @PostMapping("/tickets/{id}/remove")
    public String AirticketsRemove(@PathVariable("id") Long id,  Model model) {
        Airtickets airtickets = AirticketsRepository.findById(id).orElseThrow();
        AirticketsRepository.delete(airtickets);
        return "redirect:/tickets";
    }


}


