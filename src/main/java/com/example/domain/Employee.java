package com.example.domain;

import com.example.domain.helpers.EmployeeHelper;
import com.example.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private BigInteger salary;
    private Gender gender;
    private LocalDateTime birthDate;

    public Employee(EmployeeHelper employeeHelper) {
        this.firstName = employeeHelper.getFirstName();
        this.lastName = employeeHelper.getLastName();
        this.salary = employeeHelper.getSalary();
        this.gender = employeeHelper.getGender();
        this.birthDate = employeeHelper.getBirthDate();
    }
}
