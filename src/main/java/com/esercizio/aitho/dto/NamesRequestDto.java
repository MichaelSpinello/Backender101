package com.esercizio.aitho.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class NamesRequestDto {

    @NotBlank(message = "Invalid input")
    @Pattern(regexp = "[a-zA-Z]", message = "Invalid input")
    String firstLetter;
}
