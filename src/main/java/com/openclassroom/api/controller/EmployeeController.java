package com.openclassroom.api.controller;

import com.openclassroom.api.model.Employee;
import com.openclassroom.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private  EmployeeService employeeService;

    //add a new employee
    @PostMapping("/employee")
    public Employee creatEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    //get one employee
    @GetMapping("/employee{id}")
    public Employee getEmployee(@PathVariable("id") final  Long id){
        Optional<Employee> employee = employeeService.getEmployee(id);
        if(employee.isEmpty()){
            return null;
        }else {
            return employee.get();
        }
    }


    // get all employee
    @GetMapping("/employees")
    public Iterable<Employee> getEmployes(){
        return employeeService.getEmployees();
    }

    // update an existing employee
    @PutMapping("/employee{id}")
    public Employee updateEmployee(@PathVariable("id") final Long id,@RequestBody Employee employee){
        Optional<Employee> e = employeeService.getEmployee(id);
        if(e.isPresent()){
            Employee currentEmployee = e.get();
            String firstName = employee.getFirstName();
            if (firstName != null){
                currentEmployee.setFirstName(firstName);
            }
            String lastName = employee.getLastName();
            if (lastName != null){
                currentEmployee.setLastName(lastName);
            }
            String mail = employee.getMail();
            if (mail != null){
                currentEmployee.setMail(mail);
            }
            String password = employee.getPassword();
            if (password != null){
                currentEmployee.setPassword(password);
            }
            employeeService.saveEmployee(currentEmployee);
            return currentEmployee;
        }else {
            return null;
        }
    }
    //delete an employee
    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable("id") final  Long id){
        employeeService.deleteEmployee(id);
    }
}
