package com.example.employee.service;

import com.example.employee.dto.EmployeeRequestDto;
import com.example.employee.dto.EmployeeResponseDto;

public interface EmployeeService {

    EmployeeResponseDto create(EmployeeRequestDto employee);

}
