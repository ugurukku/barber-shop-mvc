package az.millisoft.first.service.impl;

import az.millisoft.first.entity.Barber;
import az.millisoft.first.exception.BarberNotFoundException;
import az.millisoft.first.repository.BarberRepository;
import az.millisoft.first.service.BarberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BarberServiceImpl implements BarberService {

    private final BarberRepository repository;

    @Override
    public List<Barber> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Barber barber) {
        repository.save(barber);
    }

    @Override
    public Barber getById(Integer id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new BarberNotFoundException("Barber not found for id : " + id));
    }

    @Override
    public void deleteById(Integer id) {
repository.deleteById(id);
    }
}
