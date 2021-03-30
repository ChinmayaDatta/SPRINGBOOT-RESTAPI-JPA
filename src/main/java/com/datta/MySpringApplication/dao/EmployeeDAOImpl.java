package com.datta.MySpringApplication.dao;

import com.datta.MySpringApplication.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

  // define field for entity manager
  private EntityManager entityManager;

  // define constructor injection
  @Autowired
  public EmployeeDAOImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  @Transactional
  public List<Employee> findAllEmployee() {

    // get the current hiberante session
    Session currentSession = entityManager.unwrap(Session.class);

    // create query(using native Hibernate API)
    Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);

    // execute query
    List<Employee> employeeList = query.getResultList();

    return employeeList;
    // return the results
  }
}
