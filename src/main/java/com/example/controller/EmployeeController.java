package com.example.controller;

import com.example.domain.dto.EmployeeDto;
import com.example.service.EmployeeService;
import lombok.Data;
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
    public List<EmployeeDto> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("raisesalary")
    public ResponseEntity<?> raiseSalary(@RequestParam BigInteger riseValue) {
        return employeeService.raiseSalary(riseValue);
    }

    @GetMapping("salarybetween")
    public List<EmployeeDto> findBySalaryBetween(
            @RequestParam BigInteger minSalary,
            @RequestParam BigInteger maxSalary) {
        return employeeService.findBySalaryBetween(minSalary, maxSalary);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id) {
        return employeeService.findOne(id);
    }

    @GetMapping("findbylastname")
    public List<EmployeeDto> findByLastName(@RequestParam String lastName) {
        return employeeService.findByLastName(lastName);
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody EmployeeDto employeeDto) {
        return employeeService.add(employeeDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return employeeService.delete(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> editSalary(@PathVariable Long id, @RequestParam BigInteger salary) {
        return employeeService.editSalary(id, salary);
    }
}
