/* (C)2021 */
package com.example.employee.service.impl;

import com.example.employee.dto.AccountRequestDto;
import com.example.employee.dto.AccountResponseDto;
import com.example.employee.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AccountServiceImpl implements AccountService {
    @Override
    public AccountResponseDto create(AccountRequestDto accountRequest) {
        return null;
    }
}