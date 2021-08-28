/* (C)2021 */
package com.example.employee.service;

import com.example.employee.dto.AccountRequestDto;
import com.example.employee.dto.AccountResponseDto;

public interface AccountService {

    AccountResponseDto create(AccountRequestDto accountRequest);
}
