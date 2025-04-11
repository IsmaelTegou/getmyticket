package kag.glo4.getmyticket_backend.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kag.glo4.getmyticket_backend.model.Client;
import kag.glo4.getmyticket_backend.model.Role;
import kag.glo4.getmyticket_backend.repository.ClientRepository;

@Service
public class CustomClientDetailsService implements UserDetailsService {

    private ClientRepository clientRepository;

    public void CustomUserDetailsService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
      
        Client client = clientRepository.findByEmail(usernameOrEmail)
                 .orElseThrow(() ->
                         new UsernameNotFoundException("User not found with username or email: "+ usernameOrEmail));

        Set<GrantedAuthority> authorities = client.getRoles().stream().map((Role role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(client.getEmail(),
                client.getPassword(),
                authorities);
    }
}