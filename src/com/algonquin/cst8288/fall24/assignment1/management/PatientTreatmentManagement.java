package com.algonquin.cst8288.fall24.assignment1.management;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.algonquin.cst8288.fall24.assignment1.management.*;
import com.algonquin.cst8288.fall24.assignment1.patient.*;
import com.algonquin.cst8288.fall24.assignment1.treatment.*;
import com.algonquin.cst8288.fall24.assignment1.prescription.*;

public class PatientTreatmentManagement {
	/**
	 * Create treatment plan
	 * 
	 * @param patient
	 */
	public String createTreatmentPlan(Patient patient, TreatmentPlan treatment){
		//I understand that this instant of PatientAgeManagement is not loosely coupled.
		//I had to make this part to abide by srp.
		//Since there are no other types of "AgeManagement" classes, this shouldn't be a problem.
		PatientAgeManagement ageManagement = new PatientAgeManagement();
		//TreatmentPlan treatment = new SurgeryTreatmentPlan();
		patient.setAge(ageManagement.calulatePatientAge(patient.getDateOfBirth()));
		patient.setLifeStage(ageManagement.determineLifeStage(patient.getAge()));
		return treatment.createTreatmentPlan(patient);
		
	}


	/**
	 * Create prescription
	 * 
	 * @param patient
	 * @param filename
	 * @throws IOException
	 */
	public void generatePrescription(Patient patient, String filename, PrescriptionService prescriptionService) throws IOException {
		//PrescriptionService prescriptionService = new OnlinePrescriptionService();
		BufferedWriter bwriter;
		bwriter = new BufferedWriter(new FileWriter(filename));	
		bwriter.write(prescriptionService.generatePrescription(patient));
		bwriter.close();
	}

}
