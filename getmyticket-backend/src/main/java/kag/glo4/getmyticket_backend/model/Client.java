package kag.glo4.getmyticket_backend.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@Table(name="Clients")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="client_type")
public class Client {

    @Id
    private String numeroCNI;

    private String nom;

    private String prenom;

    @Column(name = "numero_telephone")
    private Long numero;

    @Column(name = "adresse_email")
    private String email;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "client")
    private List<Reservation> listReservations;
}