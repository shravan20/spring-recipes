/* (C)2021 */
package com.example.employee.controller;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.service.EmployeeService;
import java.io.FileNotFoundException;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/employee", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping(path = "/")
    public EmployeeDto create(@RequestBody EmployeeDto employee) {
        return employeeService.create(employee);
    }

    @GetMapping(path = "/{id}")
    public EmployeeDto get(@PathVariable Integer id) throws Exception {
        return employeeService.get(id);
    }

    @GetMapping(path = "/")
    public Object filter()  {
        return employeeService.filter();
    }

    /** APIs for PDF generator examples */
    @GetMapping(path = "/generate-pdf")
    public void generateEmployeeListPdf() throws FileNotFoundException {
        employeeService.generateEmployeeListPdf();
    }

    @GetMapping(path = "/convert-to-pdf")
    public void generateHtmlToPdf() throws IOException {
        employeeService.generateHtmlToPdf();
    }
}
