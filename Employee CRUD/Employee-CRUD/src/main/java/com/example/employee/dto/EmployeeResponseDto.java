package com.example.employee.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmployeeResponseDto {
    Integer id;
    String firstName;
    String lastName;
}
