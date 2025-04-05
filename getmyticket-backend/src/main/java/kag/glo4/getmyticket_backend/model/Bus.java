package kag.glo4.getmyticket_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name =  "Bus de voyage")
public class Bus {
    @Id
    private String immatriculation;
    
    public int nbrePlaces;
}
