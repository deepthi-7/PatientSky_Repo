package com.patientsky.appointment.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 
import org.springframework.stereotype.Service;

import com.patientsky.appointment.common.Constant;
import com.patientsky.appointment.model.CalendarsData;
import com.patientsky.appointment.model.TimeSlots;

@Service
public class AppointmentService {

	private static final Logger logger = LoggerFactory.getLogger(AppointmentService.class.getName());

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constant.PATTERN);

	public Map<UUID, List<TimeSlots>> findAvailableTime(Map<UUID, CalendarsData> patientDataMap, List<UUID> calendarIds,
			int duration, LocalDateTime start, LocalDateTime end, UUID timeSlotTypeId) {

		Map<UUID, List<TimeSlots>> availableTimeSlots = new HashMap<>();
		for (UUID id : calendarIds) {

			if (patientDataMap.containsKey(id)) {

				List<TimeSlots> slots = patientDataMap.get(id).getTimeslots().stream()
						.filter(timeSlots -> (timeSlots.getCalendarId().equals(id))
								&& getSlotsWithTimeSlotTypeId(timeSlotTypeId, duration, timeSlots, patientDataMap)
								&& compareTimeInterval(start, end, timeSlots.getStart(), timeSlots.getEnd()))
						.collect(Collectors.toList());

				availableTimeSlots.put(id, slots);

			} else {
				logger.info("Apology!!.. No Appointments currently present for the Calender ID : " + id);
			}
		}

		return availableTimeSlots;
	}

	private boolean getSlotsWithTimeSlotTypeId(UUID timeSlotTypeId, int duration, TimeSlots timeSlots,
			Map<UUID, CalendarsData> patientDataMap) {

		return patientDataMap.get(timeSlots.getCalendarId()).getTimeslottypes().stream().anyMatch(timeSlotTypes -> {
			if (timeSlotTypeId != null) {
				return (timeSlotTypes.getId().equals(timeSlotTypeId) && timeSlots.getTypeId().equals(timeSlotTypeId)
						&& timeSlotTypes.getSlotSize() == duration);
			} else {
				return (timeSlots.getTypeId().equals(timeSlotTypes.getId()) && timeSlotTypes.getSlotSize() == duration);
			}
		});
	}

	private boolean compareTimeInterval(LocalDateTime start, LocalDateTime end, String availableStartDate,
			String availableEndDate) {
		LocalDateTime date1 = LocalDateTime.parse(availableStartDate, formatter);
		LocalDateTime date2 = LocalDateTime.parse(availableEndDate, formatter);

		return ((start.equals(date1) || start.isAfter(date1)) && (end.equals(date2) || end.isBefore(date2)));
	}

}
