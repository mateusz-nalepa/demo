package com.example.repository;

import com.example.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findById(Long id);

    @Modifying
    @Transactional
    @Query("update Employee e set e.salary = :salary where e.id = :id")
    int updateEmployee(@Param("id") Long id, @Param("salary") BigInteger salary);
}
