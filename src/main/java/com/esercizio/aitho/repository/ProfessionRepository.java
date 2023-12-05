package com.esercizio.aitho.repository;

import com.esercizio.aitho.model.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("professionRepository")
public interface ProfessionRepository extends JpaRepository<Profession, Long> {

    @Query("select p from Profession p inner join Person pe on pe.profession.id = p.id where pe.firstName = ?1 and pe.lastName = ?2")
    List<Profession> filterByName(String firstName, String lastName);
}
