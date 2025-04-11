package kag.glo4.getmyticket_backend.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LoginDTO {
    String email;
    String password;
}
