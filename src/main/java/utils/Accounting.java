package utils;

import model.Employee;
import model.IllegalSalaryException;
import model.Project;

/**
 * @author Sebastian Rodriguez, 2020. email: sebastian.rodriguez@rmit.edu.au
 */
public class Accounting {

    /**
     * Calculates the  Fortnight Salary of an Employee.
     * @param employee Employee to calculate the salary for.
     * @return Fortnightly Salary of the Employee.
     * @throws IllegalSalaryException 
     */
    public double calculateFortnightSalary(Employee employee){
        double fortnightSalary = 0;
        try {
        	if( employee.getPerWeekSalary() < 0) {
        		
        		throw new IllegalSalaryException("Incorrent Salary Entered");
        	}
        
        	if(employee != null && employee.getPerWeekSalary() <0) {
        		fortnightSalary = employee.getPerWeekSalary()*2;
        	}
        }catch(IllegalSalaryException e) {
         	System.out.println("Incorrent Salary Entered");
         }
		return fortnightSalary;
    }
    /**
     * Calculates the costs of a project taking in consideration the salary and bonuses of team members
     * @param project Project to calculate the cost for.
     * @return the Weekly Cost of the project
     */
    public double projectWeeklyCost(Project project){
    	double weeklyCost = 0 ;
        double salary = 0;  
        double finalCost = 0;
        for(int i  = 0 ; i < project.getTeam().size(); ++i ) {
        	salary = salary + project.getTeam().get(i).getPerWeekSalary();
        }
        salary = (salary*project.getEstimatedDuration())/7;
        
        double bonus = project.getTeam().size()*((100*project.getEstimatedDuration())/14) ;
		if(project.getTeam().size() < 5 && project.getTeam().size() > 0) {
			weeklyCost = project.getEstimatedDuration() * 25;
		}
		else if(project.getTeam().size() >= 5){
			weeklyCost = project.getEstimatedDuration() * 30;
		}
		else {
			weeklyCost = 0;
			
		}
	
        finalCost = weeklyCost + bonus+salary;
        return finalCost;
    }

}
