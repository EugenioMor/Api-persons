package com.todocodeacademy.PruebaJPA.services;

import com.todocodeacademy.PruebaJPA.models.PersonModel;
import com.todocodeacademy.PruebaJPA.repositories.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService{

    @Autowired
    private IPersonRepository personRepository;

    @Override
    public List<PersonModel> getPersons() {
        List<PersonModel> listPersons = personRepository.findAll();
        return listPersons;
    }

    @Override
    public PersonModel findPerson(Long id) {
        PersonModel findPerson = personRepository.findById(id).orElse(null);
        return findPerson;
    }

    @Override
    public PersonModel savePerson(PersonModel personModel) {
       PersonModel personMod = personRepository.save(personModel);
       return personMod;
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public PersonModel editPerson(Long id, PersonModel personModel) {

        PersonModel editPerson = this.findPerson(id);

        editPerson.setName(personModel.getName());
        editPerson.setLastname(personModel.getLastname());
        editPerson.setAge(personModel.getAge());

        return savePerson(editPerson);


    }
}
