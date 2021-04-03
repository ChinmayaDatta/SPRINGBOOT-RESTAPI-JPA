package com.datta.MySpringApplication.HibernateJPADAO;

import com.datta.MySpringApplication.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

  // define field for entity manager
  private EntityManager entityManager;

  // define constructor injection
  @Autowired
  public EmployeeDAOHibernateImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public List<Employee> findAllEmployee() {

    // get the current hiberante session
    Session currentSession = entityManager.unwrap(Session.class);

    // create query(Entity manager but with using native Hibernate API)
    Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);

    // execute query
    List<Employee> employeeList = query.getResultList();

    return employeeList;
    // return the results
  }

  @Override
  public Employee findEmployeeById(int id) {

    // get the current hiberante session
    Session currentSession = entityManager.unwrap(Session.class);

    // create query(using native Hibernate API)
    Employee query = currentSession.get(Employee.class, id);

    return query;
    // return the results
  }

  @Override
  public void saveEmployee(Employee employee) {

    // get the current hiberante session
    Session currentSession = entityManager.unwrap(Session.class);

    // create query(using native Hibernate API)
    // if id is present,it will update otherwise, it will insert
    currentSession.saveOrUpdate(employee);
  }

  @Override
  public void deleteEmployeeById(int id) {

    // get the current hiberante session
    Session currentSession = entityManager.unwrap(Session.class);

    // create query(using native Hibernate API)
    Query<Employee> query = currentSession.createQuery("delete from Employee where id =:employeeId", Employee.class);
    query.setParameter("employeeId",id);

    //execute query
     query.executeUpdate();
  }
}
