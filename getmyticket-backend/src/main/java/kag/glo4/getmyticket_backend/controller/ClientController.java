package kag.glo4.getmyticket_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kag.glo4.getmyticket_backend.dto.ClientRequestDTO;
import kag.glo4.getmyticket_backend.dto.LoginDTO;
import kag.glo4.getmyticket_backend.model.Client;
import kag.glo4.getmyticket_backend.model.Reservation;
import kag.glo4.getmyticket_backend.repository.ClientRepository;
import kag.glo4.getmyticket_backend.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientRepository clientRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public Iterable<Client> getClients(){
        return clientService.getClients();
    }

    @GetMapping("/{id}/reservations")
    public ResponseEntity<List<Reservation>> getClientRservation(@PathVariable String id){

        return ResponseEntity.ok(clientService.getClientReservations(id));
    }

    @PostMapping("/register")
    public ResponseEntity<?> createClient(@RequestBody ClientRequestDTO clientDTO){
        if(clientRepository.existsByEmail(clientDTO.getEmail())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email is already taken!");
        }
        return ResponseEntity.status(201).body(clientService.saveClient(clientDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO logInfo){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                logInfo.getEmail(), logInfo.getPassword()));
        System.out.println("hello");
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return ResponseEntity.ok("User signed-in successfully!.");
    }


    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable String id){
        return ResponseEntity.ok(clientService.getClient(id));
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<Client> updateClient(@PathVariable String id, @RequestBody Client client){
    //     Client updatedClient = clientService.updateClient(id, client);
    //     return ResponseEntity.ok(updatedClient);
    // }


    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable String id){
        clientService.deleteClient(id);
    }


}
