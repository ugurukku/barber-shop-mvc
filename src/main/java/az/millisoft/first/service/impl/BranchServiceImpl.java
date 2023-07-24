package az.millisoft.first.service.impl;

import az.millisoft.first.entity.Branch;
import az.millisoft.first.exception.BranchNotFoundException;
import az.millisoft.first.repository.BranchRepository;
import az.millisoft.first.service.BranchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BranchServiceImpl implements BranchService {

    private final BranchRepository repository;

    @Override
    public List<Branch> getAll() {
        log.info("Branch getAll() request accepted");
        return repository.findAll();
    }

    @Override
    public void save(Branch branch) {
        log.info("Branch save() request accepted");
        repository.save(branch);
    }

    @Override
    public Branch getById(Integer id) {
        log.info("Branch getById() request accepted");
        return repository
                .findById(id)
                .orElseThrow(() -> new BranchNotFoundException("Branch not found for id : " + id));
    }

    @Override
    public void deleteById(Integer id) {
        log.info("Branch deleteById() request accepted");
        repository.deleteById(id);
    }
}
