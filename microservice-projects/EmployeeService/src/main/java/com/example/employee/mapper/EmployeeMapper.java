/* (C)2021 */
package com.example.employee.mapper;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.entity.Employee;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
	componentModel = "spring",
	nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
	injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface EmployeeMapper extends ModelMapper<Employee, EmployeeDto> {
}
