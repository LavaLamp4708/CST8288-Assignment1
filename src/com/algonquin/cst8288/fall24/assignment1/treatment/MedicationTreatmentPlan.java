package com.algonquin.cst8288.fall24.assignment1.treatment;

import com.algonquin.cst8288.fall24.assignment1.patient.Patient;
import com.alognquin.cst8288.fall24.assignment1.Constants;



/**
 * 
 * Implement this
 */
public class MedicationTreatmentPlan implements TreatmentPlan {
	
	private String diagnosis;
	private String severity;
	private String medication;
	private long durationOfDoses;
	private int timesPerDay;
	
	private void setDurationOfDoses() {
		switch(severity) {
		case Constants.ACUTE:
			durationOfDoses = Constants.ACUTE_DURATION;
			break;
		case Constants.INFECTION:
			durationOfDoses = Constants.INFECTION_DURATION;
			break;
		case Constants.CHRONIC:
			durationOfDoses = Constants.CHRONIC_DURATION;
			break;
		}
	}
	
	public void setTimesPerDay(Patient patient) {
		switch(patient.getLifeStage()) {
		case Constants.CHILD:
			timesPerDay = 1;
			break;
		case Constants.YOUTH:
			timesPerDay = 2;
			break;
		case Constants.ADULT:
			timesPerDay = 3;
			break;
		}
	}
	
	/**
	 * @param medication The medication prescribed to the patient.
	 * @param severity Can be either ACUTE, INFECTION, or CHRONIC from the 'Constants' class. 
	 * @see Constants
	 */
	
	public MedicationTreatmentPlan(String diagnosis, String medication, String severity) {
		
		this.diagnosis = diagnosis;
		this.medication = medication;
		
		if(severity == Constants.ACUTE ||
				severity == Constants.INFECTION ||
				severity == Constants.CHRONIC) {
			this.severity = severity;
		} else {
			throw new IllegalArgumentException("Input invalid");
		}
		
		setDurationOfDoses();
		
	}
	
	public void setSeverity(String severity) {
		if(severity == Constants.ACUTE ||
				severity == Constants.INFECTION ||
						severity == Constants.CHRONIC) {
			this.severity = severity;
		} else {
			throw new IllegalArgumentException("Input invalid");
		}
		
		setDurationOfDoses();
				
	}
	
	public void setMedication(String medication) {
		this.medication = medication;
	}
	
	public String getDiagnosis() {
		return diagnosis;
	}
	
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	
	@Override
	public String createTreatmentPlan(Patient patient) {
		String treatmentPlan;
		if(severity == null || diagnosis == null || medication == null) {
			throw new IllegalStateException("All necessary attributes must be set before creating a treatment plan.");
		} else {
			setTimesPerDay(patient);
			treatmentPlan = String.format(
					"Patient name: %s%n"
					+ "Date of Birth: $s%n%n"
					+ "Diagnose: %s%n%n"
					+ "Rx:%n%n"
					+ "%s%n"
					+ "Dosage: %d times/day%n"
					+ "Duration: %d days%n",
					patient.getName(),
					patient.getDateOfBirth(),
					diagnosis,
					medication,
					timesPerDay,
					durationOfDoses
					);
			return treatmentPlan;
		}
	}

}
