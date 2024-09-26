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
	public void createTreatmentPlan(Patient patient){
		PatientAgeManagement age = new PatientAgeManagement();
		TreatmentPlan treatment = new SurgeryTreatmentPlan();
		patient.setAge(age.calulatePatientAge(patient.getDateOfBirth()));
		patient.setLifeStage(age.determineLifeStage(patient.getAge()));
		treatment.createTreatmentPlan(patient);
		
	}


	/**
	 * Create prescription
	 * 
	 * @param patient
	 * @param filename
	 * @throws IOException
	 */
	public void generatePrescription(Patient patient, String filename) throws IOException {
		PrescriptionService prescriptionService = new OnlinePrescriptionService();
		BufferedWriter bwriter;
		bwriter = new BufferedWriter(new FileWriter(filename));	
		bwriter.write(prescriptionService.generatePrescription(patient));
		bwriter.close();
	}

}
