package com.example.employee.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDto {
    Integer id;
    String firstName;
    String lastName;
}
