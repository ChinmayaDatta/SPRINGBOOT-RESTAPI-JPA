package com.datta.MySpringApplication.dao;

import com.datta.MySpringApplication.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAllEmployee();
}
