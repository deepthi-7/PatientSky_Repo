package com.patientsky.appointment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.patientsky.appointment.controller.AppointmentController;

@SpringBootApplication
public class PatientskyAppointmentApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PatientskyAppointmentApplication.class, args);
		AppointmentController appointmentController = context.getBean(AppointmentController.class);
		System.exit(appointmentController.appointmentHandler());
	}
 
}
