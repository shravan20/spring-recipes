/* (C)2021 */
package com.example.employee.service.impl;

import com.example.employee.commons.utils.PdfUtils;
import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.PdfGeneratorDto;
import com.example.employee.entity.Employee;
import com.example.employee.mapper.EmployeeMapper;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto create(EmployeeDto employee) {
        Employee e = employeeRepository.save(EmployeeMapper.EMPLOYEE_MAPPER.toEntity(employee));
        return EmployeeDto.builder()
                .id(e.getId())
                .firstName(e.getFirstName())
                .lastName(e.getLastName())
                .build();
    }

    @Override
    public EmployeeDto get(Integer id) throws Exception {
        return EmployeeMapper.EMPLOYEE_MAPPER.toDto(
                employeeRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("Not Found Error")));
    }

    @Override
    public void generateEmployeeListPdf() throws FileNotFoundException {
        List<PdfGeneratorDto> dtos =
                employeeRepository.findAll().stream()
                        .map(
                                employee -> {
                                    return PdfGeneratorDto.builder()
                                            .id(employee.getId())
                                            .label(
                                                    employee.getFirstName()
                                                            .concat(" ")
                                                            .concat(employee.getLastName()))
                                            .build();
                                })
                        .collect(Collectors.toList());
        PdfGeneratorDto dto = new PdfGeneratorDto();
        PdfUtils.generatePdf(dtos, UUID.randomUUID().toString());
    }

    @Override
    public void generateHtmlToPdf() throws IOException {
        PdfUtils.convertHtmlToPdf();
    }
}
