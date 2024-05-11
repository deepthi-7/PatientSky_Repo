package com.patientsky.appointment.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty; 

public class TimeSlots {

	private UUID id;

	@JsonProperty("calendar_id")
	private UUID calendarId;

	private String start;

	private String end;

	@JsonProperty("type_id")
	private UUID typeId;

	@JsonProperty("public_bookable")
	private boolean publicBookable;

	@JsonProperty("out_of_office")
	private boolean outOfOffice;

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

	public UUID getTypeId() {
		return typeId;
	}

	public void setTypeId(UUID typeId) {
		this.typeId = typeId;
	}

	public boolean isPublicBookable() {
		return publicBookable;
	}

	public void setPublicBookable(boolean publicBookable) {
		this.publicBookable = publicBookable;
	}

	public boolean isOutOfOffice() {
		return outOfOffice;
	}

	public void setOutOfOffice(boolean outOfOffice) {
		this.outOfOffice = outOfOffice;
	}

}
