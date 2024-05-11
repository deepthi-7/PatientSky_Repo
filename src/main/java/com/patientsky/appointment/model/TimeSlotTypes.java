package com.patientsky.appointment.model;

import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeSlotTypes {

	private UUID id;

	private String name;

	@JsonProperty("slot_size")
	private int slotSize;

	@JsonProperty("public_bookable")
	private boolean publicBookable;

	private String color; 
	private String icon;

	@JsonProperty("clinic_id")
	private String clinicId;

	private String deleted;

	@JsonProperty("out_of_office")
	private boolean outOfOffice;

	private boolean enabled;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSlotSize() {
		return slotSize;
	}

	public void setSlotSize(int slotSize) {
		this.slotSize = slotSize;
	}

	public boolean isPublicBookable() {
		return publicBookable;
	}

	public void setPublicBookable(boolean publicBookable) {
		this.publicBookable = publicBookable;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String isClinicId() {
		return clinicId;
	}

	public void setClinicId(String clinicId) {
		this.clinicId = clinicId;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public boolean isOutOfOffice() {
		return outOfOffice;
	}

	public void setOutOfOffice(boolean outOfOffice) {
		this.outOfOffice = outOfOffice;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
