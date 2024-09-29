package com.algonquin.cst8288.fall24.assignment1.treatment;

import com.algonquin.cst8288.fall24.assignment1.patient.Patient;
import com.alognquin.cst8288.fall24.assignment1.Constants;

/**
 * 
 * This class is responsible for implementing the business logic related to generating a treatment plan. 
 * 
 * You can use any method you prefer, such as StringBuilder or standard String, to construct the plan. Think of
 * treatment plan is a doctor notes in a summary format. 
 * Later, you will attach the treatment plan to detailed prescription.
 * 
 * An example might look like this:
 * "The patient is diagnosed with xxx and requires surgery.
 *  The patient is xxx years old with a risk factor of xxx. It is required to perform a minor surgery
 *  in order to address the xxx issue."
 * 
 * */


public class SurgeryTreatmentPlan implements TreatmentPlan{
	private String diagnosis;
	private String riskFactor;
	private String surgery;
	private String fasting;
	private String followup;
	
	public SurgeryTreatmentPlan(String diagnosis, String surgery) {
		this.diagnosis = diagnosis;
	}
	
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	
	public void setSurgery(String surgery) {
		this.surgery = surgery;
	}
	@Override
	public String createTreatmentPlan(Patient patient) {
		// TODO Auto-generated method stub
		if(patient.getLifeStage() == null) {
			throw new IllegalStateException("Life stage must not be null");
		}
		switch(patient.getLifeStage()) {
		case Constants.CHILD:
			riskFactor = Constants.HIGH;
			fasting = "No";
			followup = "next day";
			break;
		case Constants.YOUTH:
			riskFactor = Constants.MEDIUM;
			fasting = "2 hours";
			followup = "in one week";
			break;
		case Constants.ADULT:
			riskFactor = Constants.LOW;
			fasting = "8 hours";
			followup = "in one month";
			break;
		}
		String blurb = String.format(
				"The patient is diagnosed with %s and needs surgery.%n"
				+ "The patient is %d years old with a %s risk factor.%n"
				+ "%s surgery is required.%n"
				+ "%s fasting is required.%n"
				+ "A followup appointment will be %s.%n",
				diagnosis,
				patient.getAge(),
				riskFactor,
				surgery,
				fasting,
				followup
				);
		return blurb;
	}

	

}
