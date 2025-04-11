package kag.glo4.getmyticket_backend.model;

import java.util.ArrayList;
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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name="Clients")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="client_type")
public class Client {

    @Id
    private String numeroCNI;

    @Column(name = "nom utilisateur", unique = true, nullable = false)
    private String username;

    private String nom;

    private String prenom;

    @Column(name = "numero_telephone")
    private Long numero;

    @Column(name = "adresse_email",nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password; 

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "client")
    private List<Reservation> listReservations;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="clients_roles",
            joinColumns={@JoinColumn(name="client_id")},
            inverseJoinColumns={@JoinColumn(name="role_id")})
    private List<Role> roles = new ArrayList<>();
}