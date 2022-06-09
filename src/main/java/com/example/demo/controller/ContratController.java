package com.example.demo.controller;

import com.example.demo.entities.Contrat;
import com.example.demo.entities.Prestation;
import com.example.demo.service.ContratService;
import com.example.demo.service.PrestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mobiblan_rest/contrat")
public class ContratController {
    @Autowired
    ContratService contratService;
    @Autowired
    PrestationService prestationService;

    @GetMapping("/{id}")
    public Contrat getById(@PathVariable long id)
    {
        return contratService.getById(id);
    }
    @GetMapping
    public List<Contrat> getByName(@RequestParam String name)
    {
        return prestationService.getByName(name).getContrats();
    }

    @PostMapping()
    public Contrat Add(@RequestBody Contrat contrat)
    {

        return contratService.Add(contrat);
    }
}
