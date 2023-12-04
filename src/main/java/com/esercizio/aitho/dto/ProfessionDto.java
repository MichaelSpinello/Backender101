package com.esercizio.aitho.dto;

import com.esercizio.aitho.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessionDto {

    private Long id;
    private String title;
}
