package com.example.codeclan.employeeservice;

import com.example.codeclan.employeeservice.models.Department;
import com.example.codeclan.employeeservice.models.Employee;
import com.example.codeclan.employeeservice.models.Project;
import com.example.codeclan.employeeservice.repositories.DepartmentRepository;
import com.example.codeclan.employeeservice.repositories.EmployeeRepository;
import com.example.codeclan.employeeservice.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeserviceApplicationTests {

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	public void test(){

		Department department1 = new Department("DIA");
		departmentRepository.save(department1);

		Employee employee1 = new Employee("Luis Elizonto",2342,department1);
		employeeRepository.save(employee1);

		Project project1 = new Project("Blue Book",300);
		project1.addEmployee(employee1);
		projectRepository.save(project1);

	}



}
