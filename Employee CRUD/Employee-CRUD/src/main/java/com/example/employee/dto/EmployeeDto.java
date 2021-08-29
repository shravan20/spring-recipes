package com.example.employee.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    Integer id;

    @NotNull(message = "MANDATORY FIELD: firstName")
    private String firstName;

    @NotNull(message = "MANDATORY FIELD: lastName")
    private String lastName;

    @Email(message = "INVALID_FORMAT: email")
    @NotNull(message = "MANDATORY FIELD: email")
    private String email;

    @NotNull(message = "MANDATORY FIELD: salary")
    private Long salary;

    @NotNull(message = "MANDATORY FIELD: age")
    private Long age;

}
