package kag.glo4.getmyticket_backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kag.glo4.getmyticket_backend.model.Client;
import kag.glo4.getmyticket_backend.repository.ClientRepository;
import lombok.Data;

@Data
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Optional<Client> getClient(final String id) {
        return clientRepository.findById(id);
    }

    public Iterable<Client> getClients() {
        return clientRepository.findAll();
    }

    public void deleteClient(final String id) {
        clientRepository.deleteById(id);
    }

    public Client saveClient(Client client) {
        Client savedClient = clientRepository.save(client);
        return savedClient;
    }
}
