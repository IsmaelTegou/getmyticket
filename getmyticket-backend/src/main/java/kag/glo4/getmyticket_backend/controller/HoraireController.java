package kag.glo4.getmyticket_backend.controller;

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
import org.springframework.web.server.ResponseStatusException;

import kag.glo4.getmyticket_backend.model.Horaire;
import kag.glo4.getmyticket_backend.repository.HoraireRepository;

@RestController
@RequestMapping("/horaires")
public class HoraireController {

    @Autowired
    private HoraireRepository horaireRepository;

    @PostMapping
    public ResponseEntity<Horaire> saveHoraire(@RequestBody Horaire horaire){
        Horaire savedHoraire = horaireRepository.save(horaire);
        return ResponseEntity.status(201).body(savedHoraire);
    }
    
    @GetMapping
    public Iterable<Horaire> getAllHoraires(){
        return horaireRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horaire> getHoraire(@PathVariable Long id){
        return ResponseEntity.ok(horaireRepository.findById(id).orElseThrow(()-> new RuntimeException("Error occured")));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Horaire> updateHoraire(@PathVariable Long id, @RequestBody Horaire newHoraire){
        Horaire currentHoraire = horaireRepository.findById(id).orElse(null);
        currentHoraire.setHeureDebut(newHoraire.getHeureDebut());
        currentHoraire.setHeureFin(newHoraire.getHeureFin());
        currentHoraire = horaireRepository.save(currentHoraire);
        return ResponseEntity.ok(currentHoraire);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHoraire(@PathVariable Long id){
        horaireRepository.deleteById(id);
        return ResponseEntity.ok("Horaire supprimee");
    }

}
