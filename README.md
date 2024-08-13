# **Student-Details Project**


**Working on Spring Security** 
because of that all GET API endpoint will work after entering password display in console and username as "user"
will update Soon...!


Welcome to the Student-Details Project! This application provides a REST API for managing student details and their associated subjects. Follow the instructions below to set up and run the project on your local system.

## **Prerequisites**
Before you begin, ensure you have the following:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) installed.
- [Maven](https://maven.apache.org/) installed.
- [MySQL](https://dev.mysql.com/downloads/) installed and running.

## **Setup**
**1. Clone the Repository**

Clone the repository to your local system using the following command:
git clone https://github.com/RajatRuikar/student-details-project.git

**2. Create the Database**

Ensure you have a MySQL database named studentDB. You can create it using the following SQL command:
CREATE DATABASE studentDB;


**3. Configure the Application**

Open the src/main/resources/application.properties file and ensure the database URL is correctly set:
spring.datasource.url=jdbc:mysql://localhost/studentDB

**4. Run the Application**

Navigate to the project directory and run the application. Right-click on the project in your IDE, then select Run > Spring Boot App. Alternatively, you can run the application from the command line:

./mvnw spring-boot:run

## **API Endpoints**
Once the application is successfully launched, you can test the API endpoints using Postman or any other API client.

**1. Add Student**
Endpoint: POST /addstudent

Description: Add a new student and their subjects to the database.

Request Body (JSON):
{
    "studentName": "Ram",
    "subjects": [
        {
            "subjectName":"C++"
        },{
            "subjectName":"Java"
        }
    ],
    "studentAddress": "Pune"
}

**2. Get Students**
Endpoint: GET /getstudents
Description: Retrieve the details of all students along with their respective subjects.

**3. Get All Subjects**
Endpoint: GET /getallsubject
Description: Retrieve the details of all subjects with their unique subjectId.

**4. List of All Subjects**
Endpoint: GET /listofallsubjects
Description: Retrieve a list of all subjects.

## **Troubleshooting**
Ensure that MySQL is running and the database studentDB exists.
Verify the database URL in application.properties.
Check the application logs for any errors if the application fails to start.

**Working on Spring Security** 

