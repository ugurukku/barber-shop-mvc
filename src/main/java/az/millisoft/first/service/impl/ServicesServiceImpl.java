package az.millisoft.first.service.impl;

import az.millisoft.first.exception.ServiceNotFoundException;
import az.millisoft.first.repository.ServiceRepository;
import az.millisoft.first.service.ServicesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServicesServiceImpl implements ServicesService {


    private final ServiceRepository repository;

    @Override
    public List<az.millisoft.first.entity.Service> getAll() {
        log.info("Service getAll() request accepted");

        return repository.findAll();
    }

    @Override
    public void save(az.millisoft.first.entity.Service service) {
        log.info("Service save() request accepted");

        repository.save(service);
    }

    @Override
    public az.millisoft.first.entity.Service getById(Integer id) {
        log.info("Service getById() request accepted");

        return repository
                .findById(id)
                .orElseThrow(() -> new ServiceNotFoundException("Service not found for id : " + id));
    }

    @Override
    public void deleteById(Integer id) {
        log.info("Service deleteById() request accepted");

        repository.deleteById(id);
    }
}
