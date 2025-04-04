package kag.glo4.getmyticket_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kag.glo4.getmyticket_backend.dto.TrajetDTO;
import kag.glo4.getmyticket_backend.model.Agence;
import kag.glo4.getmyticket_backend.model.Trajet;
import kag.glo4.getmyticket_backend.repository.AgenceRepository;
import kag.glo4.getmyticket_backend.repository.TrajetRepository;


@RestController
@RequestMapping("/trajets")
public class TrajetController {
    
    @Autowired
    private TrajetRepository trajetRepository;

    @Autowired
    private AgenceRepository agenceRepository;

    @PostMapping
    public ResponseEntity<Trajet> saveAgence(@RequestBody TrajetDTO trajetDTO){
        Trajet trajet = new Trajet();
        Agence agenceDepart = agenceRepository.findById(trajetDTO.getAgenceDepartId()).orElse(null);
        Agence agenceArrive = agenceRepository.findById(trajetDTO.getAgenceArriveId()).orElse(null);
        trajet.setNom(trajetDTO.getNom());
        trajet.setPrix(trajetDTO.getPrix());
        trajet.setVilleDepart(agenceDepart);
        trajet.setVilleArrivee(agenceArrive);
        Trajet trajetSaved = trajetRepository.save(trajet);
        return ResponseEntity.status(HttpStatus.CREATED).body(trajetSaved);
    }

    @GetMapping
    public ResponseEntity<Iterable<Trajet>> getAllTrajets(){

        return ResponseEntity.ok(trajetRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trajet> getTrajet(@PathVariable Long id){
        Trajet trajet = trajetRepository.findById(id).orElseThrow(()-> new RuntimeException("Error occured"));
        return ResponseEntity.ok(trajet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trajet> updateAgence(@PathVariable Long id, @RequestBody TrajetDTO trajetDTO){

        Trajet trajet = trajetRepository.findById(id).orElse(null);
        Agence agenceDepart = agenceRepository.findById(trajetDTO.getAgenceDepartId()).orElse(null);
        Agence agenceArrive = agenceRepository.findById(trajetDTO.getAgenceArriveId()).orElse(null);

        trajet.setNom(trajetDTO.getNom());
        trajet.setPrix(trajetDTO.getPrix());
        trajet.setVilleDepart(agenceDepart);
        trajet.setVilleArrivee(agenceArrive);

        Trajet trajetSaved = trajetRepository.save(trajet);
        return ResponseEntity.ok(trajetSaved);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTrajet(@PathVariable Long id){
        trajetRepository.deleteById(id);
        return ResponseEntity.ok("Trajet supprime avec succes");
    }

}
