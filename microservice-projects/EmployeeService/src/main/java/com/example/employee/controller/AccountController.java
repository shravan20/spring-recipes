/* (C)2021 */
package com.example.employee.controller;

import com.example.employee.dto.AccountDto;
import com.example.employee.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/account")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AccountController {

	private final AccountService accountService;

	@PostMapping(path = "/")
	public AccountDto create(@Valid @RequestBody AccountDto accountRequest) {
		return accountService.create(accountRequest);
	}
}
