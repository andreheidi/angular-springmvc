package me.moriya.service;

import me.moriya.entity.Person;

import java.util.List;

/**
 * Created by andre on 6/22/16.
 */

public interface PersonService {

    List<Person> list();

    void save(Person person);

}
