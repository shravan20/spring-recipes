package com.example.employee.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    Integer id;
    @NotNull(message = "MANDATORY FIELD: firstName")
    String firstName;
    @NotNull(message = "MANDATORY FIELD: lastName")
    String lastName;

}
