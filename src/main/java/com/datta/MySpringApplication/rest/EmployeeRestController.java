package com.datta.MySpringApplication.rest;

import com.datta.MySpringApplication.entity.Employee;
import com.datta.MySpringApplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

  private EmployeeService employeeService;

  @Autowired
  public EmployeeRestController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @RequestMapping("employees")
  public List<Employee> findAllEmployees() {
    // http method is "get" for finding a employee
    return employeeService.findAllEmployee();
  }

  @RequestMapping("employeebyid/{id}")
  public Employee findEmployeeById(@PathVariable int id) {
    // http method is "get" for finding a employee
    return employeeService.findEmployeeById(id);
  }

  @PostMapping("createemployee")
  public void saveEmployee(@RequestBody Employee employee) {
    // http method is "post" for creating a employee
    // http method is "put" for updating an employee
    // it will force to add a new row instead of update
    employee.setId(0);

    employeeService.saveEmployee(employee);
  }

  @PutMapping("updateemployee")
  public void updateEmployee(@RequestBody Employee employee) {
    // http method is "post" for creating a employee
    // http method is "put" for updating an employee
    // it will force to add a new row instead of update

    employeeService.saveEmployee(employee);
  }

  @DeleteMapping("deleteemployees/{id}")
  public void deleteEmployeeById(@PathVariable int id) {
    employeeService.deleteEmployeeById(id);
  }
}
