package kag.glo4.getmyticket_backend.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TicketDTO {
    private int reservation_id;
    private String bus_id;
    private Long horaire_id;
    private Long trajet_id;
}
