package kag.glo4.getmyticket_backend.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;


@Data
@Entity
@DiscriminatorValue("Administrateur")
@PrimaryKeyJoinColumn(name = "numeroCNI")
public class Administrateur extends Client {
    private String fonction;
    private String idEmploye;
}
