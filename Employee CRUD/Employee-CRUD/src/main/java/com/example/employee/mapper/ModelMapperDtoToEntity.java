package com.example.employee.mapper;

public interface ModelMapperDtoToEntity<D, E> {

    E toEntity(D d);
}