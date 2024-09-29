package com.algonquin.cst8288.fall24.assignment1.prescription;

import java.util.Date;

import com.algonquin.cst8288.fall24.assignment1.treatment.MedicationTreatmentPlan;
import com.algonquin.cst8288.fall24.assignment1.treatment.SurgeryTreatmentPlan;

/**
 * 
 * Calculate the details of the prescription according to the business rules.
 * The information to include should cover daily doses, duration, disease type,
 * surgery date, etc.
 * 
 */


public class Prescription {
		
	
	long dailyDosageCount;
	long duration;
	String diseaseType;
	Date surgeryDate;
	String riskFactor;
	boolean isFastingRequired;
	Date followUpDate;
	MedicationTreatmentPlan mtp;
	SurgeryTreatmentPlan stp;
	// Add any other required attributes

	public Prescription(MedicationTreatmentPlan mtp, SurgeryTreatmentPlan stp) {
		
	}
	
	
	
	

}
