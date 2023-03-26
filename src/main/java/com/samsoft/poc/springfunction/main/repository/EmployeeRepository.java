/**
 * 
 */
package com.samsoft.poc.springfunction.main.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.samsoft.poc.springfunction.main.entity.Employee;

/**
 * @author pradh
 *
 */

@Repository
public class EmployeeRepository {

	public List<Employee> employeeList(){
		return Arrays.asList(
				new Employee(1001, "Samaresh", 36),
				new Employee(1002, "John", 28),
				new Employee(1003, "Ryan", 25),
				new Employee(1004, "Randy", 34),
				new Employee(1005, "Randy", 35)
		);
	}
}
