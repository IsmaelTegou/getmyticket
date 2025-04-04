package kag.glo4.getmyticket_backend.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kag.glo4.getmyticket_backend.model.Agence;
import kag.glo4.getmyticket_backend.repository.AgenceRepository;

@RestController
@RequestMapping("/agences")
public class AgenceController {

    @Autowired
    public AgenceRepository agenceRepository;

    @PostMapping
    public ResponseEntity<Agence> saveAgence(@RequestBody Agence agence){
        Agence agenceSaved = agenceRepository.save(agence);
        return ResponseEntity.status(HttpStatus.CREATED).body(agenceSaved);
    }

    @GetMapping
    public ResponseEntity<Iterable<Agence>> getAllAgences(){

        return ResponseEntity.ok(agenceRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agence> getAgence(@PathVariable Long id){
        Agence agence = agenceRepository.findById(id).orElseThrow(()-> new RuntimeException("Error occured"));
        return ResponseEntity.ok(agence);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agence> updateAgence(@PathVariable Long id, @RequestBody Agence newAgence){

        Agence agence = agenceRepository.findById(id).orElse(null);
        agence.setDenomination(newAgence.getDenomination());
        agence.setNom(newAgence.getNom());
        agence.setVille(newAgence.getVille());
        agence = agenceRepository.save(agence);

        return ResponseEntity.ok(agence);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAgence(@PathVariable Long id){
        agenceRepository.deleteById(id);
        return ResponseEntity.ok("Agence supprime avec succes");
    }

}
