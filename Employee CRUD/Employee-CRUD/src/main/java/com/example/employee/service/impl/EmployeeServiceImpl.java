package com.example.employee.service.impl;

import com.example.employee.dto.EmployeeRequestDto;
import com.example.employee.dto.EmployeeResponseDto;
import com.example.employee.entity.Employee;
import com.example.employee.mapper.EmployeeMapper;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private  final EmployeeMapper employeeMapper;

    @Override
    public EmployeeResponseDto create(EmployeeRequestDto employee) {
        Employee e = employeeRepository.save(employeeMapper.toEntity(employee));
        return EmployeeResponseDto.builder()
                .id(e.getId()).firstName(e.getFirstName()).lastName(e.getLastName())
                .build();
    }
}
