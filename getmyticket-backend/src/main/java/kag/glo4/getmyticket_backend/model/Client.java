package kag.glo4.getmyticket_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Clients")
public class Client {

    @Id
    private String numeroCNI;

    private String nom;

    private String prenom;

    @Column(name = "numero_telephone")
    private Long numero;

    @Column(name = "adresse_email")
    private String email;
}