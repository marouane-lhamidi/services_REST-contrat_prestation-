package com.example.demo.entities;


import javax.persistence.*;
import com.example.demo.entities.Prestation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity @AllArgsConstructor
@NoArgsConstructor
@Table(name = "contrat")
public class Contrat implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	@Column(nullable = false)
	private String zone;
	@Column(nullable = false)
	private int numéro_contrat;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "contrat_prestation",
			joinColumns = @JoinColumn(name = "contrat_id"),
			inverseJoinColumns = @JoinColumn(name = "prestation_id")
	)
	private List<Prestation> prestations = new ArrayList<>();

	public Contrat(String zone, int numéro_contrat, List<Prestation> prestations) {
		this.zone = zone;
		this.numéro_contrat = numéro_contrat;
		this.prestations = prestations;
	}
}
