package com.example.employee.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDto {

    String firstName;
    String lastName;

}
