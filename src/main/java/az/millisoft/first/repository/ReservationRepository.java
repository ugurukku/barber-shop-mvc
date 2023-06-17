package az.millisoft.first.repository;

import az.millisoft.first.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
}
