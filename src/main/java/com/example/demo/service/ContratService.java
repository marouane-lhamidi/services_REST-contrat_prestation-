package com.example.demo.service;



import com.example.demo.entities.Contrat;
import com.example.demo.entities.Prestation;
import com.example.demo.repos.ContratRepo;
import com.example.demo.repos.PrestationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ContratService {
	
    @Autowired
    ContratRepo contratRepo;

    @Autowired
    PrestationRepo prestationRepo;

    public Contrat Add(Contrat contrat)
    {

        ArrayList<Prestation> pres=new ArrayList<Prestation>();


        for(Prestation prestation:contrat.getPrestations())
        {
            if (prestationRepo.findByNom(prestation.getNom()) == null) {
                pres.add(prestationRepo.save(prestation));
            }else {
                pres.add(prestationRepo.save(prestationRepo.findByNom(prestation.getNom())));
            }
        }

        contrat.setPrestations(pres);
        return contratRepo.save(contrat);
    }

    public Contrat getById(long id)
    {

        return contratRepo.findById(id).get();
    }


}
