package com.example.employee.mapper;

public interface ModelMapperEntityToDto<E, D> {
    D toDto(E e);
}
