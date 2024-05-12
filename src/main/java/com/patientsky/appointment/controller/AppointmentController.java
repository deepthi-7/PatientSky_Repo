package com.patientsky.appointment.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.stream.Collectors;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import com.patientsky.appointment.common.Constant;
import com.patientsky.appointment.model.CalendarsData;
import com.patientsky.appointment.model.TimeSlots;
import com.patientsky.appointment.service.AppointmentService;

@Controller
public class AppointmentController {

	private static final Logger logger = LoggerFactory.getLogger(AppointmentController.class.getName());

	@Autowired
	AppointmentService appointmentService;

	@Value("${patients.details.directory}")
	private String patientDataDir;

	public int appointmentHandler() {

		String methodName = "appointmentHandler";
		logger.debug(methodName);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constant.PATTERN);

		try {
			List<CalendarsData> patientData = getPatientDetails();

			Map<UUID, CalendarsData> patientDataMap = patientData.stream()
					.collect(Collectors.toMap(data -> data.getAppointments().get(0).getCalendarId(), data -> data));

			// Real-Time Inputs
			List<UUID> calendarIds = List.of(UUID.fromString("48cadf26-975e-11e5-b9c2-c8e0eb18c1e9"),
					UUID.fromString("452dccfc-975e-11e5-bfa5-c8e0eb18c1e9"),
					UUID.fromString("48644c7a-975e-11e5-a090-c8e0eb18c1e9"));

			int duration = 30;

			// Parse the string into a LocalDateTime object
			LocalDateTime start = LocalDateTime.parse("2019-04-23T12:15:00", formatter);
			LocalDateTime end = LocalDateTime.parse("2019-04-23T12:45:00", formatter);

			UUID timeSlotTypeId = null;

			Map<UUID, List<TimeSlots>> availableTime = appointmentService.findAvailableTime(patientDataMap, calendarIds,
					duration, start, end, timeSlotTypeId);

			for (Entry<UUID, List<TimeSlots>> slots : availableTime.entrySet()) {

				List<TimeSlots> timeSlots = slots.getValue();

				timeSlots.forEach(time -> {
					System.out.println("Available time slot for the Calender ID: " + slots.getKey() + " is from "
							+ time.getStart() + " to " + time.getEnd());

				});
			}

			return Constant.SUCCESS;
		} catch (IOException | IllegalArgumentException | IllegalStateException e) {
			logger.error("Exception : " + methodName, e);
			return Constant.FAILURE;
		} catch (Exception e) {
			logger.error("Exception : " + methodName, e);
			return Constant.FAILURE;
		}

	}

	private List<CalendarsData> getPatientDetails() throws IOException {
		File directory = new File(patientDataDir);
		File[] files = directory.listFiles((dir, name) -> name.endsWith(".json"));
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		List<CalendarsData> patientData = new ArrayList<>();  

		try {
			for (File data : files) {

				CalendarsData calendars = objectMapper.readValue(new File(data.getAbsolutePath()),
						new TypeReference<>() {
				});

				patientData.add(calendars);

			}
		} catch (IOException e) {
			throw e;
		}
		return patientData;

	}
}
