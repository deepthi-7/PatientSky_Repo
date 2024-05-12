# PatientSky_Repo
PatientSky coding assessment repository

# Purpose: 
To write a program that can list down the available times for a meeting for several participants

# General Overview of the design: 
The service is developed using Spring boot Gradle project. The service is designed to collect the patient Data by reading the Json file and to store it as key value pair in map in which the key will be calendars id which is the unique factor among the patients and the common factor among appointment, Timeslot entity of the Json file to keep the data in sync.
Currently the service is taking the hardcoded input value. May be in the future this could be enhanced to take the real time input by exposing this functionality as a rest endpoint.
After collecting the patient data, the business logic is implemented in the service class which returns the available time slot to the users.

# Service implementation
Service is implemented using 3 layers
Json Files: Patient data are kept in 
Main class: Entry point to the service.  Creates a bean to the Controller class and invokes the appointmentHandler method of controller class.
	System.exit: Used to terminate the application based on the exit code. 
                        If exitcode is 0 then Application terminated without any error.
                        If exitcode is 1 then Application not ended successfully.
Model Class: Patient data is mapped to the java object.
	Appointments:-  Model class that is used to map the sub entity Appointment of the patient data Json file
•	@JsonProperty : Annotation is used to match the property instance of the Json file. Since in java it is best practice to use camel casing instead of snake casing.
	TimeSlots : Model class that is used to map the sub entity timeslots of the patient data Json file
	TimeSlotTypes : Model class that is used to map the sub entity timeslotstypes of the patient data Json file
	CalendarsData : This is the wrapper object that is used to hold the Appointments, Timeslots, TimeslotTypes entity together on an object.



Controller Class: Handles the application. The main objective of the class is to collect the patient information and pass it to service class.
	getPatientDetails: This method reads the Json file which is placed under the “src/main/resources” and maps it to CalendarsData entity which holds the patients details like Appointments, Timeslots, TimeslotTypes. This method returns the List of CalendarsData which contains the details of one or more patient.

	Inputs :  The application takes 4 real time inputs 
•	List<UUID> calendarIds: - Calendar id’s to be searched.
•	Duration :- Duration of the meeting
•	START and END TIME :- START AND END TIME OF THE MEETING. Basically, represents the interval of the meeting.
•	timeSlotTypeId:- this can be either null or can take any specific timeslottypeid. 

	findAvailableTime : This is a service class method where the logic to fetch available time slot is being implemented.
Service Class: Business logic is implemented. The main objective of the class is to implement the logic to return the available time slot.
	findAvailableTime :  This iterates through the input calendarIds to checks if the patientDataMap has CalendarsData for the particular calendars id’s. 
•	If no then displays the appropriate message on the console.
•	If yes then it go ahead with the execution and gets the available time slots.

	getSlotsWithTimeSlotTypeId : This checks if given duration and optional timeslotTypeId matches with any of the Timeslots of patient Data.
	compareTimeInterval : This checks if the given interval matches or comes within any of the allocated time slot in patients data.

# Application RUN Instruction :- 
Step 1:- Import the project from deepthi-7/PatientSky_Repo: PatientSky coding assessment repository (github.com) to he suitable IDE like STS.








Step 2 :- Provide input to the application by making changes at L53-L63
PatientSky_Repo/src/main/java/com/patientsky/appointment/controller/AppointmentController.java at main · deepthi-7/PatientSky_Repo (github.com) 
 

Step 3 :- Run the project as the Spring boot Application
 

# Different Test scenario :- 
	If the Given Calendars Id doesn’t match with any of the patient data.
 
	If the timeslottypeId  id value is given 
 
 





