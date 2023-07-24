package az.millisoft.first.service.impl;

import az.millisoft.first.entity.Reservation;
import az.millisoft.first.exception.ReservationNotFoundException;
import az.millisoft.first.repository.ReservationRepository;
import az.millisoft.first.service.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository repository;

    @Override
    public List<Reservation> getAll() {
        log.info("Reservation getAll() request accepted");
        return repository.findAll();
    }

    @Override
    public void save(Reservation reservation) {
        log.info("Reservation save() request accepted");

        repository.save(reservation);
    }

    @Override
    public Reservation getById(Integer id) {
        log.info("Reservation getById() request accepted");

        return repository
                .findById(id)
                .orElseThrow(() -> new ReservationNotFoundException("Reservation not found for id : " + id));
    }

    @Override
    public void deleteById(Integer id) {
        log.info("Reservation deleteById() request accepted");

        repository.deleteById(id);
    }
}
