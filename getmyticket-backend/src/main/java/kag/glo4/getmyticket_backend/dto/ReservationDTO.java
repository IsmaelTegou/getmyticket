package kag.glo4.getmyticket_backend.dto;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class ReservationDTO {

    private LocalDateTime dateReservation;

    public boolean status;

    private String client_id;
}
