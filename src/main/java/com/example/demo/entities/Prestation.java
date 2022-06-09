package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity @AllArgsConstructor @NoArgsConstructor
@Table(name = "prestation")
public class Prestation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prestataire_nom;
    @JsonIgnore
    @ManyToMany( mappedBy = "prestations", fetch = FetchType.LAZY)
    private List<Contrat> contrats = new ArrayList<>();
    public Prestation(String nom, String prestataire_nom, List<Contrat> contrats) {
        this.nom = nom;
        this.prestataire_nom = prestataire_nom;
        this.contrats = contrats;
    }
}
