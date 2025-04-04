package kag.glo4.getmyticket_backend.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TrajetDTO {
    private String nom;

    private double prix;

    private Long agenceDepartId;

    private Long agenceArriveId;
}
