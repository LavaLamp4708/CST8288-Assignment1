package com.algonquin.cst8288.fall24.assignment1.patient;

public class Outpatient extends Patient {
	
    private String appointmentDate;

    public Outpatient(String id, String name, String email, String phoneNumber, String dateOfBirth, String appointmentDate) {
        super(id, name, email, phoneNumber, dateOfBirth);
        this.appointmentDate = appointmentDate;
    }


    public String getAppointmentDate() {
        return appointmentDate;
    }
      /*removed implementation of the formerly abstracted admit() method,
       * as it's purpose is just to throw an exception in this subclass
       */
}

