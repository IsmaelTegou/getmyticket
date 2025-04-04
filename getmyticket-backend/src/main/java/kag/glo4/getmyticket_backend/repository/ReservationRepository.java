package kag.glo4.getmyticket_backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kag.glo4.getmyticket_backend.model.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation,Integer> {
    
}
