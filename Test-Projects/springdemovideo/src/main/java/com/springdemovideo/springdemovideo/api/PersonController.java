package com.springdemovideo.springdemovideo.api;

import com.springdemovideo.springdemovideo.model.Person;
import com.springdemovideo.springdemovideo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@NonNull @RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return  personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id,@NonNull @RequestBody Person personToUpdate){
        personService.updatePerson(id, personToUpdate);
    }

    @PutMapping(path = "{foodid}/{id}")
    public void updatePersonFavoriteFood(@PathVariable("id") UUID id ,@PathVariable("foodid") UUID foodID)
    {
        personService.updatePersonFavoriteFood(id, foodID);
    }
}