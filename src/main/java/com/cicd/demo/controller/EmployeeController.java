package com.cicd.demo.controller;

import com.cicd.demo.entity.Employee;
import com.cicd.demo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @PostMapping("/employee")
    private Employee saveEmployee(@RequestBody Employee employee){
        return employeeRepo.save(employee);
    }

    @GetMapping("/employee/{employeeID}")
    private Employee getEmployee(@PathVariable("employeeID") String employeeID){
        return employeeRepo.getEmployeeByID(employeeID);
    }

    @DeleteMapping("/employee/{employeeID}")
    private String deleteEmployee(@PathVariable("employeeID") String employeeID){
        return employeeRepo.delete(employeeID);
    }

    @PutMapping("/employee/{employeeID}")
    private String updateEmployee(@RequestBody Employee employee,@PathVariable("employeeID") String employeeID){
        return employeeRepo.update(employee,employeeID);
    }

    @PatchMapping("/employee/{employeeID}")
    private String updateEmployeeWithoutID(@RequestBody Employee employee,@PathVariable("employeeID") String employeeID){
        return employeeRepo.updateForParts(employee,employeeID);
    }
}
