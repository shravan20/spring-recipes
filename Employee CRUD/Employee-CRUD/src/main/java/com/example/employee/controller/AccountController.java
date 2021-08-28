/* (C)2021 */
package com.example.employee.controller;

import com.example.employee.dto.AccountRequestDto;
import com.example.employee.dto.AccountResponseDto;
import com.example.employee.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/account")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AccountController {

    private final AccountService service;

    public AccountResponseDto create(AccountRequestDto accountRequest) {
        return service.create(accountRequest);
    }
}
