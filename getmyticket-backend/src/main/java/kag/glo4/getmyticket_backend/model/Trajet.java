package kag.glo4.getmyticket_backend.model;

import java.time.format.SignStyle;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@Table(name = "Trajets")
public class Trajet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private double prix;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name =  "agence_depart_id")
    private Agence villeDepart;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name =  "agence_arrivee_id")
    private Agence villeArrivee;
}
