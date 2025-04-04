package kag.glo4.getmyticket_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kag.glo4.getmyticket_backend.model.Client;
import kag.glo4.getmyticket_backend.model.Reservation;
import kag.glo4.getmyticket_backend.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public Iterable<Client> getClients(){
        return clientService.getClients();
    }

    @GetMapping("/{id}/reservations")
    public ResponseEntity<List<Reservation>> getClientRservation(@PathVariable String id){

        return ResponseEntity.ok(clientService.getClientReservations(id));
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        return ResponseEntity.status(201).body(clientService.saveClient(client));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable String id){
        return ResponseEntity.ok(clientService.getClient(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable String id, @RequestBody Client client){
        Client updatedClient = clientService.updateClient(id, client);
        return ResponseEntity.ok(updatedClient);
    }


    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable String id){
        clientService.deleteClient(id);
    }


}
