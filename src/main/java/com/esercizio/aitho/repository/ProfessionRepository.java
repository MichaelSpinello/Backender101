package com.esercizio.aitho.repository;

import com.esercizio.aitho.model.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("professionRepository")
public interface ProfessionRepository extends JpaRepository<Profession, Long> {
}
