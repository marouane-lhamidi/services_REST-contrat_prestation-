package com.example.demo.repos;

import java.util.List;

import com.example.demo.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContratRepo extends JpaRepository<Contrat, Long> {
	


}