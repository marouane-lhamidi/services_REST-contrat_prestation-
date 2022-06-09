package com.example.demo.repos;

import com.example.demo.entities.Prestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PrestationRepo extends JpaRepository<Prestation, Long> {
	
	Prestation findByNom(String nom);
	

}