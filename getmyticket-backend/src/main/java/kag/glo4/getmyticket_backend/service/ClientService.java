package kag.glo4.getmyticket_backend.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kag.glo4.getmyticket_backend.dto.ClientRequestDTO;
import kag.glo4.getmyticket_backend.model.Client;
import kag.glo4.getmyticket_backend.model.Reservation;
import kag.glo4.getmyticket_backend.model.Role;
import kag.glo4.getmyticket_backend.repository.ClientRepository;
import kag.glo4.getmyticket_backend.repository.RoleRepository;
import lombok.Data;

@Data
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Client getClient(final String id) {
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public Iterable<Client> getClients() {
        return clientRepository.findAll();
    }


/*     public Client updateClient(final String id, Client updatedClient){
        Client clientToUpdate = getClient(id);
        clientToUpdate.setNom(updatedClient.getNom());
        clientToUpdate.setPrenom(updatedClient.getPrenom());
        clientToUpdate.setEmail(updatedClient.getEmail());
        clientToUpdate.setNumero(updatedClient.getNumero());

        return saveClient(clientToUpdate);
    }
 */
    public void deleteClient(final String id) {
        clientRepository.deleteById(id);
    }


    public Client saveClient(ClientRequestDTO clientDTO) {
        Client newClient = new Client();
        newClient.setNumeroCNI(clientDTO.getNumeroCNI());
        newClient.setNumero(clientDTO.getNumero());
        newClient.setNom(clientDTO.getNom());
        newClient.setPrenom(clientDTO.getPrenom());
        newClient.setUsername(clientDTO.getNom()+clientDTO.getPrenom());
        newClient.setEmail(clientDTO.getEmail());
        newClient.setPassword(passwordEncoder.encode(clientDTO.getPassword()));
        Role role = roleRepository.findByName("CLIENT").orElse(null);
        if(role == null){
            role = checkRoleExist();
        }
        newClient.setRoles(Arrays.asList(role));
        Client savedClient = clientRepository.save(newClient);
        return savedClient;
    }
    
    public List<Reservation> getClientReservations(String id){
        Client client = getClient(id);
        return client.getListReservations();
    }

    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("CLIENT");
        return roleRepository.save(role);
    }
}
