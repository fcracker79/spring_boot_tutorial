package io.mirko.services;

import io.mirko.model.Spaturno;

public interface SpaturnoService {
    Iterable<Spaturno> findAll();
    String saveNew(String name, String surname, int age);
    Spaturno findById(String id);
    boolean updateSpaturno(String uuid, String name, String surname, int age);
}
