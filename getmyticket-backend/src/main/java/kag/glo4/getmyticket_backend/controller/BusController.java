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

import kag.glo4.getmyticket_backend.model.Bus;
import kag.glo4.getmyticket_backend.repository.BusRepository;

@RestController
@RequestMapping("/bus")
public class BusController {

    @Autowired
    private BusRepository busRepository;
    
    @PostMapping
    public ResponseEntity<Bus> saveBus(@RequestBody Bus newBus){
        Bus busSaved = busRepository.save(newBus);
        return ResponseEntity.status(HttpStatus.CREATED).body(busSaved);
    }

    @GetMapping
    public ResponseEntity<Iterable<Bus>> getAllBus(){
        return ResponseEntity.ok(busRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bus> getBus(@PathVariable String id){
        return ResponseEntity.ok(busRepository.findById(id).orElse(null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBus(@PathVariable String id){
        busRepository.deleteById(id);
        return ResponseEntity.ok("Bus supprime avec succes");
    }

}
