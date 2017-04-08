package io.mirko.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpaturnoRepository extends CrudRepository<Spaturno, Long> {
    List<Spaturno> findByName(String name);
    List<Spaturno> findBySurname(String surname);
    Spaturno findByUuid(String uuid);
}
