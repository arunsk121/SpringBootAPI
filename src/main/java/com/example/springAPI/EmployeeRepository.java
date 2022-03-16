package com.example.springAPI;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	/* This is an interface which includes methods that perform CRUD operations to manipulate and fetch empDemo database 
	 * Existing methods can be overridden
	 * Custom methods can be added here
	 */
}
