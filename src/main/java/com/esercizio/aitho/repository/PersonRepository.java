package com.esercizio.aitho.repository;

import com.esercizio.aitho.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("personRepository")
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("select p from Person p where p.firstName = ?1 and p.lastName = ?2")
    List<Person> filterByName(String firstName, String lastName);
}
