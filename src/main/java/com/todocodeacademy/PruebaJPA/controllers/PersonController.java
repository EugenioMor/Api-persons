package com.todocodeacademy.PruebaJPA.controllers;

import com.todocodeacademy.PruebaJPA.models.PersonModel;
import com.todocodeacademy.PruebaJPA.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<PersonModel> getPersons(){
        return personService.getPersons();
    }

    @GetMapping("/{id}")
    public PersonModel findPersonById(@PathVariable Long id){
        PersonModel personMod = personService.findPerson(id);
        return personMod;
    }

    @PostMapping("/create")
    public PersonModel savePerson(@RequestBody PersonModel personModel){
        PersonModel saveP = personService.savePerson(personModel);
        return saveP;
    }

    @PutMapping("/edit/{id}")
    public PersonModel editPerson(@PathVariable Long id, @RequestBody PersonModel personModel){

        PersonModel personEd = personService.editPerson(id, personModel);
        return personEd;
    }

    @DeleteMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id){
        try {
            personService.deletePerson(id);
            return "Person deleted successfully";
        }catch (Exception e){
            return "Error";
        }


    }
}
