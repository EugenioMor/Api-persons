package com.todocodeacademy.PruebaJPA.repositories;

import com.todocodeacademy.PruebaJPA.models.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends JpaRepository<PersonModel, Long> {
}
