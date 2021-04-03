package com.datta.MySpringApplication.HibernateJPADAO;

import com.datta.MySpringApplication.entity.Employee;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {
  // define field for entity manager
  private EntityManager entityManager;

  // define constructor injection
  @Autowired
  public EmployeeDAOJPAImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public List<Employee> findAllEmployee() {

    // Entity manager using JPA API
    Query query = entityManager.createQuery("from Employee");

    // execute query
    List<Employee> employeeList = query.getResultList();
    return employeeList;
  }

  @Override
  public Employee findEmployeeById(int id) {

    // entity manager using JPA API
    Employee employee = entityManager.find(Employee.class, id);

    return employee;
  }

  @Override
  public void saveEmployee(Employee employee) {
    // entity manager using JPA API
    Employee employeeObject = entityManager.merge(employee);

    // we are setting it because we can use this employee object id in rest controller to print on
    // screen
    employee.setId(employeeObject.getId());
  }

  @Override
  public void deleteEmployeeById(int id) {
    // entity manager using JPA API
    Query query =
        entityManager.createQuery("delete from Employee where id =:employeeId", Employee.class);
    query.setParameter("employeeId", id);

    // execute query
    query.executeUpdate();
  }
}
