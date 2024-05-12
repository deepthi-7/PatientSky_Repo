package com.patientsky.appointment;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.util.ReflectionTestUtils;

import com.patientsky.appointment.controller.AppointmentController;
import com.patientsky.appointment.model.CalendarsData;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("unittest")
public class PatientSkyAppointmentController {

	private String directory = "src/test/resources";

	@InjectMocks
	AppointmentController appointmentController;

	@Test
	public void getPatientDetailsTest() {
		
		ReflectionTestUtils.setField(appointmentController, "patientDataDir", directory);
		List<CalendarsData> calendarsData = ReflectionTestUtils.invokeMethod(appointmentController, "getPatientDetails");
		Assertions.assertEquals(1,calendarsData.size());
	}
}
