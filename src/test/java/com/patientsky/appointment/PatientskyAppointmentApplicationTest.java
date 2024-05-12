package com.patientsky.appointment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.util.ReflectionTestUtils;

import com.patientsky.appointment.common.Constant;
import com.patientsky.appointment.controller.AppointmentController;
import com.patientsky.appointment.model.CalendarsData;
import com.patientsky.appointment.model.TimeSlotTypes;
import com.patientsky.appointment.model.TimeSlots;
import com.patientsky.appointment.service.AppointmentService;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("unittest")
class PatientskyAppointmentApplicationTest {

	@InjectMocks
	AppointmentService appointmentService;

	@InjectMocks
	AppointmentController appointmentController;

	private String directory = "src/test/resources";
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constant.PATTERN);

	@Test
	public void findAvailableTimeTestSuccess() {

		Map<UUID, CalendarsData> patientDataMap = new HashMap<>();
		CalendarsData calendarsData = new CalendarsData();
		List<TimeSlots> timeSlotsList = new ArrayList<>();
		List<TimeSlotTypes> timeSlotsTypesList = new ArrayList<>();

		UUID uUID = UUID.fromString("48cadf26-975e-11e5-b9c2-c8e0eb18c1e9");
		List<UUID> calendarIds = List.of(UUID.fromString("48cadf26-975e-11e5-b9c2-c8e0eb18c1e9"));

		TimeSlots timeSlots = new TimeSlots();
		timeSlots.setCalendarId(UUID.fromString("48cadf26-975e-11e5-b9c2-c8e0eb18c1e9"));
		timeSlots.setStart("2019-04-23T12:15:00");
		timeSlots.setEnd("2019-04-23T12:30:00");
		timeSlotsList.add(timeSlots);
		timeSlots.setTypeId(UUID.fromString("4529821e-975e-11e5-bbaf-c8e0eb18c1e9"));

		TimeSlotTypes timeSlotsTypes = new TimeSlotTypes();
		timeSlotsTypes.setId(UUID.fromString("48cadf26-975e-11e5-b9c2-c8e0eb18c1e9"));
		timeSlotsTypes.setSlotSize(30);
		timeSlotsTypesList.add(timeSlotsTypes);

		calendarsData.setTimeslots(timeSlotsList);
		calendarsData.setTimeslottypes(timeSlotsTypesList);
		patientDataMap.put(uUID, calendarsData);

		int duration = 30;

		// Parse the string into a LocalDateTime object
		LocalDateTime start = LocalDateTime.parse("2019-04-23T12:15:00", formatter);
		LocalDateTime end = LocalDateTime.parse("2019-04-23T12:30:00", formatter);

		UUID timeSlotTypeId = UUID.fromString("4529821e-975e-11e5-bbaf-c8e0eb18c1e9");

		Assertions.assertEquals(1, appointmentService
				.findAvailableTime(patientDataMap, calendarIds, duration, start, end, timeSlotTypeId).size());

	}

	@Test
	public void findAvailableTimeTestFail() {

		Map<UUID, CalendarsData> patientDataMap = new HashMap<>();
		CalendarsData calendarsData = new CalendarsData();
		List<TimeSlots> timeSlotsList = new ArrayList<>();
		List<TimeSlotTypes> timeSlotsTypesList = new ArrayList<>();

		UUID uUID = UUID.fromString("48cadf26-975e-11e5-b9c2-c8e0eb18c1e2");
		List<UUID> calendarIds = List.of(UUID.fromString("48cadf26-975e-11e5-b9c2-c8e0eb18c1e9"));

		TimeSlots timeSlots = new TimeSlots();
		timeSlots.setCalendarId(UUID.fromString("48cadf26-975e-11e5-b9c2-c8e0eb18c1e9"));
		timeSlots.setStart("2019-04-23T12:15:00");
		timeSlots.setEnd("2019-04-23T12:30:00");
		timeSlotsList.add(timeSlots);
		timeSlots.setTypeId(UUID.fromString("4529821e-975e-11e5-bbaf-c8e0eb18c1e9"));

		TimeSlotTypes timeSlotsTypes = new TimeSlotTypes();
		timeSlotsTypes.setId(UUID.fromString("48cadf26-975e-11e5-b9c2-c8e0eb18c1e9"));
		timeSlotsTypes.setSlotSize(30);
		timeSlotsTypesList.add(timeSlotsTypes);

		calendarsData.setTimeslots(timeSlotsList);
		calendarsData.setTimeslottypes(timeSlotsTypesList);
		patientDataMap.put(uUID, calendarsData);

		int duration = 30;

		// Parse the string into a LocalDateTime object
		LocalDateTime start = LocalDateTime.parse("2019-04-23T12:15:00", formatter);
		LocalDateTime end = LocalDateTime.parse("2019-04-23T12:30:00", formatter);

		UUID timeSlotTypeId = UUID.fromString("4529821e-975e-11e5-bbaf-c8e0eb18c1e9");

		Assertions.assertNotEquals(1, appointmentService
				.findAvailableTime(patientDataMap, calendarIds, duration, start, end, timeSlotTypeId).size());

	}

	@Test
	public void getPatientDetailsTest() {

		ReflectionTestUtils.setField(appointmentController, "patientDataDir", directory);
		List<CalendarsData> calendarsData = ReflectionTestUtils.invokeMethod(appointmentController,
				"getPatientDetails");
		Assertions.assertEquals(1, calendarsData.size());
	}

}
