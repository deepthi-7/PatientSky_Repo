package com.patientsky.appointment.model;

import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Appointments { 

	private UUID id;

	@JsonProperty("calendar_id")
	private UUID calendarId;

	private String start;
	private String end;

	@JsonProperty("patient_id")
	private UUID patientId;

	@JsonProperty("patient_comment")
	private UUID patientComment;

	private String note;

	@JsonProperty("time_slot_type_id")
	private UUID timeSlotTypeId;

	@JsonProperty("type_id")
	private UUID typeId;

	private int state;

	@JsonProperty("out_of_office_location")
	private String outOfOfficeLocation;

	@JsonProperty("out_of_office")
	private boolean outOfOffice;

	private boolean completed;

	@JsonProperty("is_scheduled")
	private boolean isScheduled;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(UUID calendarId) {
		this.calendarId = calendarId;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public UUID getPatientId() {
		return patientId;
	}

	public void setPatientId(UUID patientId) {
		this.patientId = patientId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public UUID getTimeSlotTypeId() {
		return timeSlotTypeId;
	}

	public void setTimeSlotTypeId(UUID timeSlotTypeId) {
		this.timeSlotTypeId = timeSlotTypeId;
	}

	public UUID getTypeId() {
		return typeId;
	}

	public void setTypeId(UUID typeId) {
		this.typeId = typeId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getOutOfOfficeLocation() {
		return outOfOfficeLocation;
	}

	public void setOutOfOfficeLocation(String outOfOfficeLocation) {
		this.outOfOfficeLocation = outOfOfficeLocation;
	}

	public boolean isOutOfOffice() {
		return outOfOffice;
	}

	public void setOutOfOffice(boolean outOfOffice) {
		this.outOfOffice = outOfOffice;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public boolean isScheduled() {
		return isScheduled;
	}

	public void setScheduled(boolean isScheduled) {
		this.isScheduled = isScheduled;
	}

}
