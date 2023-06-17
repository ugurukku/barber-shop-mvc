package az.millisoft.first.repository;

import az.millisoft.first.entity.Barber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarberRepository extends JpaRepository<Barber,Integer> {
}
