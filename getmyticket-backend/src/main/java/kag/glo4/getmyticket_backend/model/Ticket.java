package kag.glo4.getmyticket_backend.model;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@Table(name = "Tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Trajet trajet;

    @ManyToOne
    private Bus bus;

    @ManyToOne
    private Horaire horaire;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    private Reservation reservation;

}
