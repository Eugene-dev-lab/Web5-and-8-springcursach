package com.example.demo.Controllers;


import com.example.demo.models.Clients;
import com.example.demo.models.Tours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ToursController {
    @Autowired
    private com.example.demo.repo.ToursRepository ToursRepository;
    @GetMapping("/tours")
    public String Tours(Model model) {
        Iterable<Tours> tours = ToursRepository.findAll();
        model.addAttribute("tours", tours );
        return "tours-main";
    }

    @GetMapping("/tours/add")
    public String Add(Model model) {
        return "tours-add";
    }

    @PostMapping("/tours/add")
    public String ToursAdd(@RequestParam String start_date, @RequestParam String end_date, @RequestParam String destination, @RequestParam String tour_price, Model model) {
        Tours tours = new Tours(start_date, end_date, destination, tour_price);
        ToursRepository.save(tours);
        return "redirect:/tours";
    }



    @GetMapping("/tours/{id}/edit")
    public String toursEdit(@PathVariable(value = "id" ) long id, Model model) {
        if (!ToursRepository.existsById(id)) {
            return "redirect:/tours";
        }
        Optional<Tours> tours = ToursRepository.findById(id);
        ArrayList<Tours> tour = new ArrayList<>();
        tours.ifPresent(tour::add);
        model.addAttribute("tours", tour);
        return "tours-edit";
    }

    @PostMapping("/tours/{id}/edit")
    public String ToursUpdate(@PathVariable("id") Long id,@RequestParam String start_date, @RequestParam String end_date, @RequestParam String destination, @RequestParam String tour_price,Model model) {
        Tours tours = ToursRepository.findById(id).orElseThrow();
        tours.setStart_date(start_date);
        tours.setEnd_date(end_date);
        tours.setDestination(destination);
        tours.setTour_price(tour_price);
        ToursRepository.save(tours);
        return "redirect:/tours";

    }


    @PostMapping("/tours/{id}/remove")
    public String ToursDelete(@PathVariable("id") Long id,  Model model) {
        Tours tours = ToursRepository.findById(id).orElseThrow();
        ToursRepository.delete(tours);
        return "redirect:/tours";
    }
}
