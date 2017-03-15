package com.example;

import com.example.domain.Employee;
import com.example.enums.Gender;
import com.example.repository.EmployeeRepository;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@Component
public class RunAtStart implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    @Override
    public void run(String... strings) throws Exception {
        Employee employee = Employee
                .builder()
                .birthDate(LocalDateTime.of(1994, 10, 14, 8, 0))
                .firstName("Jan")
                .lastName("Kowalski")
                .email("jan@kowalski.pl")
                .salary(BigInteger.valueOf(1500))
                .gender(Gender.M)
                .build();

        employeeRepository.save(employee);
        Employee employee2 = Employee
                .builder()
                .birthDate(LocalDateTime.of(1990, 12, 8, 16, 0))
                .firstName("Marian")
                .lastName("Stepien")
                .email("marian@stepin.pl")
                .salary(BigInteger.valueOf(1600))
                .gender(Gender.M)
                .build();

        employeeRepository.save(employee2);

        Employee employee3 = Employee
                .builder()
                .birthDate(LocalDateTime.of(1992, 11, 8, 8, 0))
                .firstName("Katarzyna")
                .lastName("Nowak")
                .email("katarzyna@nowak.pl")
                .salary(BigInteger.valueOf(1750))
                .gender(Gender.W)
                .build();

        employeeRepository.save(employee3);

    }
}
