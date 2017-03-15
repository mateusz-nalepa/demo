package com.example.domain;

import com.example.domain.dto.EmployeeDto;
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

    @Size(max = 50, message = "LastName can have maximum 50 char.")
    @Column(length = 50, nullable = false)
    private String lastName;

    @Size(min = 1, max = 50)
    @Column(length = 50, unique = true, nullable = false)
    @Email(message = "Email is in incorrect format")
    private String email;

    @Column(length = 1)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private BigInteger salary;
    private LocalDateTime birthDate;

    public Employee(EmployeeDto employeeDto) {
        this.firstName = employeeDto.getFirstName();
        this.lastName = employeeDto.getLastName();
        this.salary = employeeDto.getSalary();
        this.gender = employeeDto.getGender();
        this.birthDate = employeeDto.getBirthDate();
        this.email = employeeDto.getEmail();
    }
}
