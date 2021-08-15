package com.example.employee.mapper;

public interface ModelMapper<E, D>  extends ModelMapperEntityToDto<E, D>, ModelMapperDtoToEntity<D, E>{
}
