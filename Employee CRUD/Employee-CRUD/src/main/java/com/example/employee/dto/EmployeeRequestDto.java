package com.example.employee.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmployeeRequestDto {

    String firstName;
    String lastName;

}
