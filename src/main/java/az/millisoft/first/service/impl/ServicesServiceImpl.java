package az.millisoft.first.service.impl;

import az.millisoft.first.exception.ServiceNotFoundException;
import az.millisoft.first.repository.ServiceRepository;
import az.millisoft.first.service.ServicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicesServiceImpl implements ServicesService {


    private final ServiceRepository repository;

    @Override
    public List<az.millisoft.first.entity.Service> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(az.millisoft.first.entity.Service service) {
        repository.save(service);
    }

    @Override
    public az.millisoft.first.entity.Service getById(Integer id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ServiceNotFoundException("Service not found for id : " + id));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
