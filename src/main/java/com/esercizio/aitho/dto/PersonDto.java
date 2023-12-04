package com.esercizio.aitho.dto;

import com.esercizio.aitho.model.Profession;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String professionTitle;

}
