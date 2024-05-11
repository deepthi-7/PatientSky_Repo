package com.patientsky.appointment.model;

import java.util.List;

public class CalendarsData {
 
	private List<Appointments> appointments;
	private List<TimeSlots> timeslots;
	private List<TimeSlotTypes> timeslottypes;

	public List<Appointments> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointments> appointments) {
		this.appointments = appointments;
	}

	public List<TimeSlots> getTimeslots() {
		return timeslots;
	}

	public void setTimeslots(List<TimeSlots> timeslots) {
		this.timeslots = timeslots;
	}

	public List<TimeSlotTypes> getTimeslottypes() {
		return timeslottypes;
	}

	public void setTimeslottypes(List<TimeSlotTypes> timeslottypes) {
		this.timeslottypes = timeslottypes;
	}

}
