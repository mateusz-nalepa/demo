package com.example.controller;

import com.example.domain.helpers.EmployeeHelper;
import com.example.service.EmployeeService;
import lombok.Data;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@Data
@RestController
@RequestMapping("employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeHelper> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("{id}")
    public HttpEntity<?> findOne(@PathVariable Long id) {
        return employeeService.findOne(id);
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody EmployeeHelper employeeHelper) {
        return employeeService.add(employeeHelper);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return employeeService.delete(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @RequestParam BigInteger salary) {
        return employeeService.edit(id, salary);
    }
}
