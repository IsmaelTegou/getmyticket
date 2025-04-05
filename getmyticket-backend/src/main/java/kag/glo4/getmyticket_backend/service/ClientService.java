package kag.glo4.getmyticket_backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kag.glo4.getmyticket_backend.model.Client;
import kag.glo4.getmyticket_backend.model.Reservation;
import kag.glo4.getmyticket_backend.repository.ClientRepository;
import lombok.Data;

@Data
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client getClient(final String id) {
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public Iterable<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client updateClient(final String id, Client updatedClient){
        Client clientToUpdate = getClient(id);
        clientToUpdate.setNom(updatedClient.getNom());
        clientToUpdate.setPrenom(updatedClient.getPrenom());
        clientToUpdate.setEmail(updatedClient.getEmail());
        clientToUpdate.setNumero(updatedClient.getNumero());
        return saveClient(clientToUpdate);
    }

    public void deleteClient(final String id) {
        clientRepository.deleteById(id);
    }

    public Client saveClient(Client client) {
        System.out.println(client);
        Client savedClient = clientRepository.save(client);
        return savedClient;
    }
    
    public List<Reservation> getClientReservations(String id){
        Client client = getClient(id);
        return client.getListReservations();
    }
}
