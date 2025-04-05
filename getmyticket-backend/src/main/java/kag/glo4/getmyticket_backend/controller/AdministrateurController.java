package kag.glo4.getmyticket_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kag.glo4.getmyticket_backend.model.Administrateur;
import kag.glo4.getmyticket_backend.repository.AdministrateurRepository;

@RestController
@RequestMapping("/administrateurs")
public class AdministrateurController {

    
    @Autowired
    private AdministrateurRepository administrateurRepository;

    @PostMapping
    public ResponseEntity<Administrateur>  saveAdministrateur(@RequestBody Administrateur adm){
       Administrateur savedAdministrateur =  administrateurRepository.save(adm);
       return ResponseEntity.status(201).body(savedAdministrateur);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrateur>  getAdministrateur(@PathVariable String id){
        return ResponseEntity.ok(administrateurRepository.findById(id).orElseThrow(()->new RuntimeException("Error occured")));
    }

    @GetMapping
    public ResponseEntity<Iterable<Administrateur>> getAllAdministrateur(){
        return ResponseEntity.ok(administrateurRepository.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleterAdministrator(@PathVariable String id){
        administrateurRepository.deleteById(id);

        return ResponseEntity.ok("Administrateur supprime");
    }




}
