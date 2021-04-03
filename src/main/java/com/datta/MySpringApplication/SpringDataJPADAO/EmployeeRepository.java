package com.datta.MySpringApplication.SpringDataJPADAO;

import com.datta.MySpringApplication.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //http://localhost:3307/chinmaya-api/members
    //Here we no need to write any code, thats the magic of spring data JPA
    // Spring data JPA will provide all CRUD operations by default
    //we just need to pass the entity name and primary key id
}
