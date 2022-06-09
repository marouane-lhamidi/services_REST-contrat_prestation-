package com.example.demo.controller;

import com.example.demo.entities.Prestation;
import com.example.demo.service.PrestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mobiblan_rest/prestation")
public class PrestationController {
    @Autowired
    PrestationService prestationService;

    @GetMapping("/{id}")
    public Prestation getById(@PathVariable long id)
    {
        return prestationService.getById(id);
    }

    @GetMapping
    public Prestation getByName(@RequestParam String name)
    {
        return prestationService.getByName(name);
    }

    @PostMapping()
    public Prestation Add(@RequestBody Prestation prestation)
    {
        return prestationService.Add(prestation);
    }
}
