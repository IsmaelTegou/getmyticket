package kag.glo4.getmyticket_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequestDTO {
    private String numeroCNI;
    private String nom;
    private String prenom;
    private String email;
    private Long numero;
    private String password;
}
