package kag.glo4.getmyticket_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kag.glo4.getmyticket_backend.model.Client;
import kag.glo4.getmyticket_backend.service.ClientService;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public Iterable<Client> getClients(){
        return clientService.getClients();
    }

}
