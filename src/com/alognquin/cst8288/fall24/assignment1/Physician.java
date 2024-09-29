package com.alognquin.cst8288.fall24.assignment1;

import java.io.IOException;

import com.algonquin.cst8288.fall24.assignment1.management.*;
import com.algonquin.cst8288.fall24.assignment1.patient.*;
import com.algonquin.cst8288.fall24.assignment1.treatment.*;

public class Physician {
	
    public static void main(String[] args) throws IOException {
    	PatientAgeManagement pam = new PatientAgeManagement();
    	PatientValidator pv = new PatientValidator();
    	PatientTreatmentManagement ptm = new PatientTreatmentManagement();
    	
    	/**
    	 * 
    	 * Create two instances of the 'Patient' class and apply 'MedicationTreatment.java' and 
    	 * 'SurgeryTreatment.java' to generate and populate the treatment plans for each patient. 
    	 * Then, use 'PatientManagement.java' to generate both treatment plans. Once the treatment 
    	 * plan is generated. Use PrescriptionService.java to generate prescriptions
    	 * in different format (.txt or .html) 
    	 *
    	 * 
    	 */
    	
     Patient patient1 = new Outpatient("1", "Andrew Smith", "andrewsmith@gmail.com", "613-123-4567", "2000-01-01", "2024-10-01");
     if(pv.validatePatientData(patient1)) {
    	 TreatmentPlan tp1 = new MedicationTreatmentPlan("COVID 19", "Ibuprofen", Constants.ACUTE);
    	 String plan = ptm.createTreatmentPlan(patient1, tp1);
     }
        
    }

   
}


