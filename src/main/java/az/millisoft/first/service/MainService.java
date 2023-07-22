package az.millisoft.first.service;

import java.util.List;

public interface MainService<T> {

    List<T> getAll();

    void save(T t);

    T getById(Integer id);

    void deleteById(Integer id);

}
