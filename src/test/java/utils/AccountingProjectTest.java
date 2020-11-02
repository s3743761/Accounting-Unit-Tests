package utils;


import model.Employee;
import model.IllegalSalaryException;
import model.IllegalTeamMemberException;
import model.Project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;




/**
 *  Implement and test {@link Accounting#projectWeeklyCost(Project)} that respects the following constraints:
 *
 *  <ul>
 *      <li>Every employee gets a bonus of 100 AUD fortnightly for every project.</li>
 *      <li>A project has a fix daily cost of 25 AUD with less than 5 members and 30 AUD after</li>
 *  </ul>
 *
 * Each test criteria must be in an independent test method and named as specified in the README.
 *
 * Initialize the test object with setUp method.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

class AccountingProjectTest {
	Accounting account = null;

	Project project = null;

	@BeforeAll
	void methods() {
		account = new Accounting();
		Date myDate =new Date("25/05/2020");
		Employee employee = new Employee("Name",myDate);
		Employee employee2 = new Employee("Prabhav",myDate);
		Employee employee3 = new Employee("Mehra",myDate);
		Employee employee4 = new Employee("Mohit",myDate);
		project = new Project();
		project.setEstimatedDuration(7);
		try {
			project.addTeamMember(employee);
			project.addTeamMember(employee2);
			project.addTeamMember(employee3);
			project.addTeamMember(employee4);
			employee.setPerWeekSalary(100);
			employee2.setPerWeekSalary(200);
			employee3.setPerWeekSalary(300);
			employee4.setPerWeekSalary(400);
			
		}catch (IllegalSalaryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}	
		catch (IllegalTeamMemberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	void calculatesWeeklyCost_throwsException_ifNotValidSalaryAndEmployee() {
		assertEquals(1375, account.projectWeeklyCost(project), "Must be 1375");
	}
	
	@Test
	void calculatesWeeklyCostFor6_throwsException_ifNotValidSalaryAndEmployee() {
		Date myDate =new Date("25/05/2020");
		Employee employee = new Employee("Name",myDate);
		Employee employee2 = new Employee("Prabhav",myDate);
		Employee employee3 = new Employee("Mehra",myDate);
		Employee employee4 = new Employee("Mohit",myDate);
		Employee employee5 = new Employee("Chetna",myDate);
		Employee employee6 = new Employee("Aman",myDate);
		project = new Project();
		project.setEstimatedDuration(7);
		try {
			project.addTeamMember(employee);
			project.addTeamMember(employee2);
			project.addTeamMember(employee3);
			project.addTeamMember(employee4);
			project.addTeamMember(employee5);
			project.addTeamMember(employee6);
			employee.setPerWeekSalary(100);
			employee2.setPerWeekSalary(200);
			employee3.setPerWeekSalary(300);
			employee4.setPerWeekSalary(400);
			employee5.setPerWeekSalary(500);
			employee6.setPerWeekSalary(600);
			assertEquals(2610, account.projectWeeklyCost(project), "Must be 2610");
		}catch (IllegalSalaryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}	
		catch (IllegalTeamMemberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	void calculatesWeeklyCostFor0Emp_throwsException_ifNotValidSalaryAndEmployee() {
		Project project = new Project();
		project.setEstimatedDuration(7);
		assertEquals(0, account.projectWeeklyCost(project), "Must be 0");
		
		
	}

}