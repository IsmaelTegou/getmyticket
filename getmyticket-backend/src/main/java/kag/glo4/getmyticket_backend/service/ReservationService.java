package kag.glo4.getmyticket_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kag.glo4.getmyticket_backend.dto.ReservationDTO;
import kag.glo4.getmyticket_backend.model.Client;
import kag.glo4.getmyticket_backend.model.Reservation;
import kag.glo4.getmyticket_backend.repository.ReservationRepository;


@Service
public class ReservationService {
    

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ClientService clientService;

    public Reservation saveReservation(Reservation res){
        return reservationRepository.save(res);
    }
    public void deleteReservation(int id){
        Reservation res = getReservation(id);
        Client client = res.getClient();
        client.getListReservations().remove(res);
        reservationRepository.deleteById(id);
    }

    public Iterable<Reservation> getAllReservations(){
        return reservationRepository.findAll();
    }

    public Reservation getReservation(int id){
        return reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Error occured"));
    }

    public Reservation updateReservation(int id, ReservationDTO newReservation){
        Reservation res = getReservation(id);
        Client client = clientService.getClient(newReservation.getClient_id());
        res.setStatus(newReservation.status);
        res.setClient(client);
        saveReservation(res);
        return res;
    }
}
