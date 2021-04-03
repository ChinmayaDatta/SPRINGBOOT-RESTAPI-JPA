package com.datta.MySpringApplication.HibernateJPADAO;

import com.datta.MySpringApplication.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAllEmployee();

    public Employee findEmployeeById(int id);

    public void saveEmployee(Employee employee);

    public void deleteEmployeeById(int id);
}
