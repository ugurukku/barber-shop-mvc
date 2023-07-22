package az.millisoft.first.service.impl;

import az.millisoft.first.entity.Branch;
import az.millisoft.first.exception.BranchNotFoundException;
import az.millisoft.first.repository.BranchRepository;
import az.millisoft.first.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepository repository;

    @Override
    public List<Branch> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Branch branch) {
        repository.save(branch);
    }

    @Override
    public Branch getById(Integer id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new BranchNotFoundException("Branch not found for id : " + id));
    }

    @Override
    public void deleteById(Integer id) {
repository.deleteById(id);
    }
}
