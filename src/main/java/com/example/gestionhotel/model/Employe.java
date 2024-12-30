package com.example.gestionhotel.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.Year;

@Entity
@Data
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idemploye;

    @NotBlank(message = "Le Nom ne peut pas etre  nul")
    private String nom;

    @NotBlank(message = "Le Prenom  ne peut pas etre nul")
    private String prenom;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Le Poste ne peut pas etre nul")
    private Posteemploye posteemploye;

    @NotBlank(message = " Le Telephone ne peut pas etre nul ")
    private String telephone;


    public Long getIdemploye() {
        return idemploye;
    }

    public void setIdemploye(Long idemploye) {
        this.idemploye = idemploye;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Posteemploye getPosteemploye() {
        return posteemploye;
    }

    public void setPosteemploye(Posteemploye posteemploye) {
        this.posteemploye = posteemploye;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
