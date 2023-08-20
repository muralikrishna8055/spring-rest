package com.springRest.service;

import com.springRest.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    List <Employee> fetchEmployee();

    Employee findById(Long id);

    Employee updateEmployee(Employee employee,Long id);

    void deleteEmployee(Long id);
}
