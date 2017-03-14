package com.example.service;


import com.example.domain.Employee;
import com.example.domain.helpers.EmployeeHelper;
import com.example.repository.EmployeeRepository;
import lombok.Data;
import org.springframework.http.HttpEntity;
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

    public List<EmployeeHelper> findAll() {
        return employeeRepository
                .findAll()
                .stream()
                .map(EmployeeHelper::new)
                .collect(Collectors.toList());
    }

    public ResponseEntity<Void> add(EmployeeHelper employeeHelper) {
        employeeRepository.save(new Employee(employeeHelper));
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

    public HttpEntity<?> findOne(Long id) {
        return employeeRepository
                .findById(id)
                .map(EmployeeHelper::new)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<?> edit(Long id, BigInteger salary) {
        return new ResponseEntity<>(
                employeeRepository.updateEmployee(id, salary) == 0 ? HttpStatus.NOT_FOUND : HttpStatus.OK
        );
    }


}
