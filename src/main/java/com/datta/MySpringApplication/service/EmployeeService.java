package com.datta.MySpringApplication.service;

import com.datta.MySpringApplication.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public List<Employee> findAllEmployee();

    public Employee findEmployeeById(int id);

    public void saveEmployee(Employee employee);

    public void deleteEmployeeById(int id);
}
