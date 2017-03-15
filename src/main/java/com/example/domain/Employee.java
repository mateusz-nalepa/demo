package com.example.domain;

import com.example.domain.helpers.EmployeeHelper;
import com.example.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Size;
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

    @Size(max = 50)
    @Column(length = 50, nullable = false)
    private String firstName;

    @Size(max = 50)
    @Column(length = 50, nullable = false)
    private String lastName;

    @Size(min = 1, max = 50)
    @Column(length = 50, unique = true, nullable = false)
    @Email
    private String email;

    @Column(length = 1)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private BigInteger salary;
    private LocalDateTime birthDate;

    public Employee(EmployeeHelper employeeHelper) {
        this.firstName = employeeHelper.getFirstName();
        this.lastName = employeeHelper.getLastName();
        this.salary = employeeHelper.getSalary();
        this.gender = employeeHelper.getGender();
        this.birthDate = employeeHelper.getBirthDate();
        this.email = employeeHelper.getEmail();
    }
}
