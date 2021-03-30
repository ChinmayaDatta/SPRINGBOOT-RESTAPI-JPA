package com.datta.MySpringApplication.rest;

import com.datta.MySpringApplication.dao.EmployeeDAO;
import com.datta.MySpringApplication.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

  private EmployeeDAO employeeDAO;

  @Autowired
  public EmployeeRestController(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  @RequestMapping("employees")
  public List<Employee> findAllEmployees() {
    return employeeDAO.findAllEmployee();
  }

    @RequestMapping("check")
    public String findAll() {
        return "hello";
    }
}
