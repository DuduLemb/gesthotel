package com.example.gestionhotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Data
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idchambre;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Le Type de la chambre  ne peut pas etre nul")
    private Typechambre typechambre;

    @NotNull(message = "Le Prix ne peut pas etre nul")
    @Positive
    private Double prix;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "L'Etat de la chambre  ne peut pas etre nul")
    private Etatchambre etatchambre;

    @NotNull(message = "La Capacite ne peut pas etre nul")
    @Positive
    private Long capacite;

    public Long getIdchambre() {
        return idchambre;
    }

    public void setIdchambre(Long idchambre) {
        this.idchambre = idchambre;
    }

    public Typechambre getTypechambre() {
        return typechambre;
    }

    public void setTypechambre(Typechambre typechambre) {
        this.typechambre = typechambre;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Etatchambre getEtatchambre() {
        return etatchambre;
    }

    public void setEtatchambre(Etatchambre etatchambre) {
        this.etatchambre = etatchambre;
    }

    public Long getCapacite() {
        return capacite;
    }

    public void setCapacite(Long capacite) {
        this.capacite = capacite;
    }
}
