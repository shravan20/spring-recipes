/* (C)2021 */
package com.example.employee.service.impl;

import com.example.employee.dto.AccountDto;
import com.example.employee.entity.Account;
import com.example.employee.repository.AccountRepository;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AccountServiceImpl implements AccountService {

	private final AccountRepository accountRepository;
	private final EmployeeRepository employeeRepository;
	private final ModelMapper mapper;

	@Override
	public AccountDto create(AccountDto accountRequest) {
		Account account = mapper.map(accountRequest, Account.class);
		account.setEmployee(employeeRepository.findById(accountRequest.getEmployeeId()).orElseThrow(() -> new RuntimeException("NOT_FOUND_ERROR")));
		return mapper.map(accountRepository.save(account), AccountDto.class);
	}
}
