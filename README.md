# Application Run Instructions 
# Step 1 
Import the project from https://github.com/deepthi-7/PatientSky_Repo to the suitable IDE like STS.

![image](https://github.com/deepthi-7/PatientSky_Repo/assets/72294385/09bd7627-5bc2-4752-a7cc-ab699e5819d3)


# Step 2
Provide input to the application by making changes at L53-L63
https://github.com/deepthi-7/PatientSky_Repo/blob/main/src/main/java/com/patientsky/appointment/controller/AppointmentController.java#L53-L63

![image](https://github.com/deepthi-7/PatientSky_Repo/assets/72294385/344a1b37-72dc-4515-adfd-e4c0e4c82a4e)

 

# Step 3
Run the project as the Spring boot Application
![image](https://github.com/deepthi-7/PatientSky_Repo/assets/72294385/d8b076b5-3889-49ee-aeca-dcbe9cb8b7a9)


# Different Test scenario 
	If the Given Calendars Id doesn’t match with any of the patient data.
![image](https://github.com/deepthi-7/PatientSky_Repo/assets/72294385/22b99728-2bb0-4880-80c9-645c01bc1897)

 
	If the timeslottypeId  id value is given 
![image](https://github.com/deepthi-7/PatientSky_Repo/assets/72294385/2d83d48f-014f-4bbb-b9a8-57a7b70dc87f)

![image](https://github.com/deepthi-7/PatientSky_Repo/assets/72294385/85782e24-fa3a-4596-97f3-f6c2e002b934)

 

	If the timeslottypeId  id is null

![image](https://github.com/deepthi-7/PatientSky_Repo/assets/72294385/44f56678-c13d-4265-a869-be58bd15bb24)


![image](https://github.com/deepthi-7/PatientSky_Repo/assets/72294385/ac0e1926-b51a-4b0a-8128-ab4d2de626e8)


# General Overview of the design 
The service is developed using Spring boot Gradle project. The service is designed to collect the patient Data by reading the Json file and to store it as key value pair in map in which the key will be calendars id which is the unique factor among the patients and the common factor among appointment, Timeslot entity of the Json file to keep the data in sync.

Currently the service is taking the hardcoded input value. May be in the future this could be enhanced to take the real time input by exposing this functionality as a rest endpoint.
After collecting the patient data,service returns the available time slots to the particular calendar Id.



 

 
 

 





