package me.moriya.controller;

import me.moriya.entity.Person;
import me.moriya.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * Created by andre on 6/20/16.
 */
@Controller
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Person> list() {
        return this.personService.list();
    }

    @RequestMapping(value = "/save", method = RequestMethod.PUT)
    public void save(@RequestBody Person person) {
        this.personService.save(person);
    }
}