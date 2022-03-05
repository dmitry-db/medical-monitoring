package liga.medical.medicalmonitoring.core.service;

import java.util.List;

public interface CrudService<E> {
    E findById(Long id);

    List<E> findAll();

    void save(E element);

    void deleteById(Long id);

    void update(Long id, E element);
}
