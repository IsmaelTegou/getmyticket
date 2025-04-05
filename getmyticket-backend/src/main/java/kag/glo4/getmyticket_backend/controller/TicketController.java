package kag.glo4.getmyticket_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kag.glo4.getmyticket_backend.dto.TicketDTO;
import kag.glo4.getmyticket_backend.model.Bus;
import kag.glo4.getmyticket_backend.model.Horaire;
import kag.glo4.getmyticket_backend.model.Reservation;
import kag.glo4.getmyticket_backend.model.Ticket;
import kag.glo4.getmyticket_backend.model.Trajet;
import kag.glo4.getmyticket_backend.repository.BusRepository;
import kag.glo4.getmyticket_backend.repository.HoraireRepository;
import kag.glo4.getmyticket_backend.repository.TicketRepository;
import kag.glo4.getmyticket_backend.repository.TrajetRepository;
import kag.glo4.getmyticket_backend.service.ReservationService;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private TrajetRepository trajetRepository;

    @Autowired
    private HoraireRepository horaireRepository;


    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody TicketDTO ticketDTO){
        Reservation res = reservationService.getReservation(ticketDTO.getReservation_id());
        Trajet trajet = trajetRepository.findById(ticketDTO.getTrajet_id()).orElse(null);
        Horaire horaire = horaireRepository.findById(ticketDTO.getHoraire_id()).orElse(null);
        Bus bus = busRepository.findById(ticketDTO.getBus_id()).orElse(null);

        Ticket ticket = new Ticket();
        ticket.setReservation(res);
        ticket.setTrajet(trajet);
        ticket.setHoraire(horaire);
        ticket.setBus(bus);

        ticketRepository.save(ticket);
        return ResponseEntity.status(HttpStatus.CREATED).body(ticket);
    }

    @GetMapping
    public ResponseEntity<Iterable<Ticket>> getAllTickets(){
        return ResponseEntity.ok(ticketRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicket(@PathVariable Long id){
        return ResponseEntity.ok(ticketRepository.findById(id).orElse(null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTicket(@PathVariable Long id){
        Ticket tick = ticketRepository.findById(id).orElse(null);
        Reservation res = tick.getReservation();
        res.setTicket(null);
        ticketRepository.deleteById(id);
        return ResponseEntity.ok("Ticket supprime");
    }


}
