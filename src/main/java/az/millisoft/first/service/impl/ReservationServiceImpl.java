package az.millisoft.first.service.impl;

import az.millisoft.first.entity.Reservation;
import az.millisoft.first.exception.ReservationNotFoundException;
import az.millisoft.first.repository.ReservationRepository;
import az.millisoft.first.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository repository;

    @Override
    public List<Reservation> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Reservation reservation) {
        repository.save(reservation);
    }

    @Override
    public Reservation getById(Integer id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ReservationNotFoundException("Reservation not found for id : " + id));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
