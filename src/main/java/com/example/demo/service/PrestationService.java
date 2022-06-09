package com.example.demo.service;


import com.example.demo.entities.Contrat;
import com.example.demo.entities.Prestation;
import com.example.demo.repos.ContratRepo;
import com.example.demo.repos.PrestationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PrestationService {

    @Autowired
    ContratRepo contratRepo;

    @Autowired
    PrestationRepo prestationRepo;


    public Prestation Add(Prestation prestation)
    {
        ArrayList<Contrat> contracts=new ArrayList<Contrat>();

        for(Contrat contrat:prestation.getContrats())
        {       contracts.add(contratRepo.save(contrat));}

        prestation.setContrats(contracts);


        return prestationRepo.save(prestation);
    }

    public Prestation getById(long id)
    {

        return prestationRepo.findById(id).get();
    }

    public Prestation getByName(String name)
    {

        return prestationRepo.findByNom(name);
    }


}
