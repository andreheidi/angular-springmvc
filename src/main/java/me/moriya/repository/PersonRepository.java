package me.moriya.repository;

import me.moriya.entity.Person;
import org.springframework.stereotype.Repository;

/**
 * Created by andre on 6/22/16.
 */
@Repository
public interface PersonRepository extends GenericRepository<Person> {
}