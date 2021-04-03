package com.datta.MySpringApplication.service;

import com.datta.MySpringApplication.HibernateJPADAO.EmployeeDAO;
import com.datta.MySpringApplication.SpringDataJPADAO.EmployeeRepository;
import com.datta.MySpringApplication.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private EmployeeRepository employeeRepository;

  @Autowired
  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public List<Employee> findAllEmployee() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee findEmployeeById(int id) {

    // using "Optional" is an different pattern instead of checking for nulls
    Optional<Employee> result = employeeRepository.findById(id);

    Employee employee = null;
    if (result.isPresent()) {
      employee = result.get();
    }
    return employee;
  }

  @Override
  public void saveEmployee(Employee employee) {
    employeeRepository.save(employee);
  }

  @Override
  public void deleteEmployeeById(int id) {
    employeeRepository.deleteById(id);
  }
}
