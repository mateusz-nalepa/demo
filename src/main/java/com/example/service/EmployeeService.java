package com.example.service;


import com.example.domain.Employee;
import com.example.domain.dto.EmployeeDto;
import com.example.repository.EmployeeRepository;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<EmployeeDto> findAll() {
        return employeeRepository
                .findAll()
                .stream()
                .map(EmployeeDto::new)
                .collect(Collectors.toList());
    }

    public ResponseEntity<Void> add(EmployeeDto employeeDto) {
        employeeRepository.save(new Employee(employeeDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<?> delete(Long id) {
        return employeeRepository
                .findById(id)
                .map(e -> {
                    employeeRepository.delete(e);
                    return new ResponseEntity<>(HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<?> findOne(Long id) {
        return employeeRepository
                .findById(id)
                .map(EmployeeDto::new)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<?> editSalary(Long id, BigInteger salary) {
        return new ResponseEntity<>(
                employeeRepository.editSalary(id, salary) == 0 ? HttpStatus.NOT_FOUND : HttpStatus.OK
        );
    }

    public List<EmployeeDto> findBySalaryBetween(BigInteger minSalary, BigInteger maxSalary) {
        return employeeRepository
                .findBySalaryBetween(minSalary, maxSalary)
                .stream()
                .map(EmployeeDto::new)
                .collect(Collectors.toList());
    }

    public List<EmployeeDto> findByLastName(String lastName) {
        return employeeRepository
                .findByLastNameContaining(lastName)
                .stream()
                .map(EmployeeDto::new)
                .collect(Collectors.toList());
    }

    public ResponseEntity<?> raiseSalary(BigInteger riseValue) {
        return new ResponseEntity<>(
                employeeRepository.raiseSalaryToAllEmployees(riseValue) + " employees got a raise",
                HttpStatus.OK);
    }
}
