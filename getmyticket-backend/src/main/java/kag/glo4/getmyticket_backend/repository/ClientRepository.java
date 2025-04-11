package kag.glo4.getmyticket_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kag.glo4.getmyticket_backend.model.Client;

@Repository
public interface ClientRepository extends  JpaRepository<Client,String> {
    Optional<Client> findByEmail(String email);
    Optional<Client> findByUsernameOrEmail(String username, String email);
    Optional<Client> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}

