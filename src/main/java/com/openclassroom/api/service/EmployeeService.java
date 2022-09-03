package com.openclassroom.api.service;

import com.openclassroom.api.model.Employee;
import com.openclassroom.api.repository.EmployeeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<Employee> getEmployee(final long id){
        return employeeRepository.findById(id);
    }

    public Iterable<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee){
        Employee saveEmployee = employeeRepository.save(employee);
        return saveEmployee;
    }

    public  void deleteEmployee(final  long id){
        employeeRepository.deleteById(id);
    }

}
