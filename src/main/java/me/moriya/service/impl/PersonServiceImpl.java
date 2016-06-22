package me.moriya.service.impl;

import me.moriya.entity.Person;
import me.moriya.repository.PersonRepository;
import me.moriya.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by andre on 6/22/16.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> list() {
        return this.personRepository.findAll();
    }

    @Override
    public void save(Person person) {
        this.personRepository.save(person);
    }
}
