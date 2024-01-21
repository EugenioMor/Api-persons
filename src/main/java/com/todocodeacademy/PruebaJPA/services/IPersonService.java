package com.todocodeacademy.PruebaJPA.services;

import com.todocodeacademy.PruebaJPA.models.PersonModel;

import java.util.List;

public interface IPersonService {

    public List<PersonModel> getPersons();

    public PersonModel findPerson(Long id);

    public PersonModel savePerson(PersonModel personModel);

    public void deletePerson(Long id);

    public PersonModel editPerson(Long id, PersonModel personModel);

}
