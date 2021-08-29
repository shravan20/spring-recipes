/* (C)2021 */
package com.example.employee.dto;

import com.example.employee.enums.AccountType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDto {

    private Integer id;

    private String accountNumber;

    private Integer employeeId;

    private AccountType type;
}
