package com.springRest.service.impl;


import com.springRest.exception.ResourceNotFoundException;
import com.springRest.model.Employee;
import com.springRest.repository.EmployeeRepository;
import com.springRest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService  {

    @Autowired
   private EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);

    }
    @Override
    public List<Employee> fetchEmployee(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
      Optional< Employee> employee=employeeRepository.findById(id);

      if(employee.isPresent()){
          return employee.get();
      }
      else{
          throw new ResourceNotFoundException("Employee","ID",id);
      }
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        Employee exsistingEmployee=employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee","ID",id));
        exsistingEmployee.setFirstName(employee.getFirstName());
        exsistingEmployee.setLastName(employee.getLastName());
        exsistingEmployee.setEmail(employee.getEmail());
        employeeRepository.save(exsistingEmployee);
        return exsistingEmployee;
    }

    @Override
    public void deleteEmployee(Long id) {

        Employee exsistEmpl=employeeRepository.findById(id).orElseThrow(
                () ->new ResourceNotFoundException("Employee","ID",id));
        employeeRepository.deleteById(id);


    }


}
