package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.EmployeeManagement;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeManagement, Integer> {

}
