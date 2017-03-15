package com.example.domain.helpers;

import com.example.domain.Employee;
import com.example.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.MapKeyEnumerated;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeHelper {

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

    private Gender gender;
    private BigInteger salary;
    private LocalDateTime birthDate;

    public EmployeeHelper(Employee employee) {
        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.salary = employee.getSalary();
        this.gender = employee.getGender();
        this.birthDate = employee.getBirthDate();
        this.email = employee.getEmail();

    }
}
