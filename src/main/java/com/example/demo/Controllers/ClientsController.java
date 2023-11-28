package com.example.demo.Controllers;


import com.example.demo.models.Airtickets;
import com.example.demo.models.Clients;
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
public class ClientsController {
    @Autowired
    private com.example.demo.repo.ClientsRepository ClientsRepository;
    @GetMapping("/clients")
    public String Client(Model model) {
        Iterable<Clients> clients = ClientsRepository.findAll();
        model.addAttribute("clients", clients );
        return "clients-main";
    }

    @GetMapping("/clients/add")
    public String Add(Model model) {
        return "clients-add";
    }

    @PostMapping("/clients/add")
    public String ClietsAdd(@RequestParam String first_name, @RequestParam String last_name, @RequestParam String address, @RequestParam String phone_number, @RequestParam String email, Model model) {
        Clients clients = new Clients(first_name, last_name, address, phone_number, email);
        ClientsRepository.save(clients);
        return "redirect:/clients";
    }



    @GetMapping("/clients/{id}/edit")
    public String clientsEdit(@PathVariable(value = "id" ) long id, Model model) {
        if (!ClientsRepository.existsById(id)) {
            return "redirect:/clients";
        }
        Optional<Clients> clients = ClientsRepository.findById(id);
        ArrayList<Clients> client = new ArrayList<>();
        clients.ifPresent(client::add);
        model.addAttribute("clients", client);
        return "clients-edit";
    }

    @PostMapping("/clients/{id}/edit")
    public String ClientsUpdate(@PathVariable("id") Long id,@RequestParam String first_name, @RequestParam String last_name, @RequestParam String address, @RequestParam String phone_number, @RequestParam String email,Model model) {
        Clients clients = ClientsRepository.findById(id).orElseThrow();
        clients.setFirst_name(first_name);
        clients.setLast_name(last_name);
        clients.setAddress(address);
        clients.setPhone_number(phone_number);
        clients.setEmail(email);
        ClientsRepository.save(clients);
        return "redirect:/clients";
    }


    @PostMapping("/clients/{id}/remove")
    public String ClientsRemove(@PathVariable("id") Long id,  Model model) {
        Clients clients = ClientsRepository.findById(id).orElseThrow();
        ClientsRepository.delete(clients);
        return "redirect:/clients";
    }

}
