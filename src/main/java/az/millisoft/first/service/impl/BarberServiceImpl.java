package az.millisoft.first.service.impl;

import az.millisoft.first.entity.Barber;
import az.millisoft.first.exception.BarberNotFoundException;
import az.millisoft.first.repository.BarberRepository;
import az.millisoft.first.service.BarberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BarberServiceImpl implements BarberService {

    private final BarberRepository repository;

    @Override
    public List<Barber> getAll() {
        log.info("Barber getAll() request accepted");
        return repository.findAll();
    }

    @Override
    public void save(Barber barber) {
        log.info("Barber save() request accepted");
        repository.save(barber);
    }

    @Override
    public Barber getById(Integer id) {
        log.info("Barber getById() request accepted");
        return repository
                .findById(id)
                .orElseThrow(() -> new BarberNotFoundException("Barber not found for id : " + id));
    }

    @Override
    public void deleteById(Integer id) {
        log.info("Barber deleteById() request accepted");
        repository.deleteById(id);
    }
}
