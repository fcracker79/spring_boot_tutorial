package io.mirko.services;

import io.mirko.model.Spaturno;
import io.mirko.model.SpaturnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SpaturnoServiceImpl implements SpaturnoService {
    @Autowired
    private SpaturnoRepository spaturnoRepository;

    @Override
    public Iterable<Spaturno> findAll() {
        return spaturnoRepository.findAll();
    }

    @Override
    public String saveNew(String name, String surname, int age) {
        final Spaturno spaturno = spaturnoRepository.save(new Spaturno(name, surname, age));
        return spaturno.getUuid();
    }

    @Override
    public Spaturno findById(String id) {
        return spaturnoRepository.findByUuid(id);
    }

    @Override
    public boolean updateSpaturno(String uuid, String name, String surname, int age) {
        final Spaturno existingSpaturno = findById(uuid);
        if (existingSpaturno == null) {
            return false;
        }
        existingSpaturno.setName(name);
        existingSpaturno.setSurname(surname);
        existingSpaturno.setAge(age);
        spaturnoRepository.save(existingSpaturno);
        return true;
    }
}
