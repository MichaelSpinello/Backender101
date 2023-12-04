package com.esercizio.aitho.mapper;

public interface Mapper <E, D>{

    E toEntity(D dto);
    D toDto(E entity);
}
