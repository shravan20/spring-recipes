/* (C)2021 */
package com.example.employee.mapper;

import org.mapstruct.factory.Mappers;

public interface ModelMapper<E, D>
	extends ModelMapperEntityToDto<E, D>, ModelMapperDtoToEntity<D, E> {

	EmployeeMapper EMPLOYEE_MAPPER = Mappers.getMapper(EmployeeMapper.class);
	AccountMapper ACCOUNT_MAPPER = Mappers.getMapper(AccountMapper.class);
}
