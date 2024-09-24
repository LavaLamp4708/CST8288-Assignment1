package com.algonquin.cst8288.fall24.assignment1.management;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import com.alognquin.cst8288.fall24.assignment1.Constants;

public class PatientAgeManagement {
	
	/**
	 * Calculate patient age based on date of birth
	 * 
	 * @param dob
	 * @return
	 */
	public long calulatePatientAge(String dob) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfBirth = LocalDate.parse(dob, formatter);
		
        LocalDate currentDate = LocalDate.now();
        long age = Period.between(dateOfBirth, currentDate).getYears();
        
        return age;
      
	}
	
	/**
	 * Determine life stage based on age
	 * 
	 * @param age
	 * @return
	 */
	public String determineLifeStage(long age) {
		
		return (age <= 6) ? Constants.CHILD : 
     	   (age <= 18) ? Constants.YOUTH : 
     		  Constants.ADULT;   
	}
}
