/**
 * 
 */
package com.samsoft.poc.springfunction.main.util;

import java.util.function.Consumer;

import org.springframework.stereotype.Component;

import com.samsoft.poc.springfunction.main.entity.Employee;

/**
 * @author pradh
 *
 */
@Component
public class EmployeeConsumer implements Consumer<Employee> {

	@Override
	public void accept(Employee e) {
		System.out.println(e.getName() + "\t" + e.getId() + "\t" + e.getAge());
	}

}
