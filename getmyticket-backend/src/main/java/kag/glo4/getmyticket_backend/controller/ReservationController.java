package kag.glo4.getmyticket_backend.controller;

import java.time.LocalDateTime;
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

import kag.glo4.getmyticket_backend.dto.ReservationDTO;
import kag.glo4.getmyticket_backend.model.Client;
import kag.glo4.getmyticket_backend.model.Reservation;
import kag.glo4.getmyticket_backend.service.ClientService;
import kag.glo4.getmyticket_backend.service.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    
    @Autowired
    private ReservationService reservationService;

    @Autowired ClientService clientService;

    @PostMapping
    public ResponseEntity<Reservation> addNewReservation(@RequestBody ReservationDTO reservationDTO){

        Client client = clientService.getClient(reservationDTO.getClient_id());
        Reservation reservation = new Reservation();  
        reservation.setStatus(reservationDTO.status);
        reservation.setDateReservation(LocalDateTime.now());
        reservation.setClient(client);
        reservationService.saveReservation(reservation);

        return ResponseEntity.status(HttpStatus.CREATED).body(reservation);
    }

    @GetMapping
    public ResponseEntity<Iterable<Reservation>> getAllReservations(){
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getSpecificReservation(@PathVariable int id){
        return ResponseEntity.ok(reservationService.getReservation(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelReservation(@PathVariable int id ){
        reservationService.deleteReservation(id);
        return ResponseEntity.ok("Reservation  Annulee");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@RequestBody ReservationDTO newRes, @PathVariable int id){
        return ResponseEntity.ok(reservationService.updateReservation(id, newRes));  
    }
   
}
