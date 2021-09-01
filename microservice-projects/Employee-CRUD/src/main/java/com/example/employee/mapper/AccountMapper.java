/* (C)2021 */
package com.example.employee.mapper;

import com.example.employee.dto.AccountDto;
import com.example.employee.entity.Account;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
	componentModel = "spring",
	nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
	injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AccountMapper extends ModelMapper<Account, AccountDto> {
}
