package com.example.domain.helpers;

import com.example.domain.Employee;
import com.example.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeHelper {

    private long id;
    private String firstName;
    private String lastName;
    private BigInteger salary;
    private Gender gender;
    private LocalDateTime birthDate;

    public EmployeeHelper(Employee employee) {
        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.salary = employee.getSalary();
        this.gender = employee.getGender();
        this.birthDate = employee.getBirthDate();
    }
}
