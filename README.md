# PatientSky_Repo
PatientSky coding assessment repository

# General Overview of the design: 
The service is developed using Spring boot Gradle project. The service is designed to collect the patient Data by reading the Json file and to store it as key value pair in map in which the key will be calendars id which is the unique factor among the patients and the common factor among appointment, Timeslot entity of the Json file to keep the data in sync.
Currently the service is taking the hardcoded input value. May be in the future this could be enhanced to take the real time input by exposing this functionality as a rest endpoint.
After collecting the patient data, the business logic is implemented in the service class which returns the available time slot to the users.
 
 





