# QUIZ APP

This is a Quiz App built using Java Spring Boot for backend development, JPA for database interaction, and MySQL as the database. The app allows an admin to manage questions and create quizzes for users to attempt.

## Features

+ **Question Management:** Admin can add, edit, and delete questions in the Questions Database.
+ **Quiz Creation:** Admin can create quizzes by selecting questions from the Questions Database. Quizzes are stored in the Quiz Database.
+ **Quiz Generation:** Quizzes are generated based on the number of questions and category type specified by the admin.
+ **Quiz Attempt:** Users can attempt quizzes by following the link provided by the admin.
+ **Scoring:** Users receive scores upon completing a quiz.

## Components

+ **Backend:** Java Spring Boot is used for building the backend APIs.
+ **Java Version:** Java JDK 17
+ **Spring Boot Version:** 3.4.0
+ **Database:** MySQL 8 is used as the database management system. There are two databases.
+ **Questions Database:** Contains all the questions.
+ **Quiz Database:** Stores quizzes generated by the admin.
+ **API Calls:** Postman is used for testing and interacting with the backend APIs.

## Usage

+ **Setup MySQL Database:** Set up MySQL and create two databases: questionsdb(for testing use questionsEx.csv file attched in Quiz-App folder) and quizdb.
+ **Run the Application:** Run the Java Spring Boot application to start the backend server.
+ **Admin Operations:** Use Postman or any REST client to interact with the backend APIs for question management and quiz creation.
+ **User Operations:** Users can attempt quizzes by following the link provided by the admin. Upon completion, users receive their scores

## Development Setup

+ **Clone the Repository:** Clone this repository to your local machine.
+ **Configure Database:** Set up MySQL and configure the database connection in the application properties file.
+ **Run the Application:** Run the Spring Boot application locally using your IDE or Maven command line.
+ **API Testing:** Use Postman to test the backend APIs for question management and quiz creation.
