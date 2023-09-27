# USER MANAGEMENT SYSTEM

**Name: Pankaj Kalra, Batch: FS-11**
[GITHUB](https://github.com/Pankaj-dev98/user-management-system-geekster.git)

## Frameworks and languages used
- Source code: Java 20
- Base framework: SpringBoot with inbuilt TomCat server
- Dependencies: spring-starter-web: Includes several dependencies for JSON parsing, Spring MVC, Spring web REST for RESTful services, etc.

## Data Flow
- Controller: Rest controller is managed by java class "UserController". It exposes all the required endpoints for this project.
- Services: Clients can use the project for the following services:
	+ Add a new user.
	+ Get a user by his unique ID
	+ Fetch all users in a deserialized JSON
	+ Update any/all user's info via his ID
	+ Delete a particular user from the system-geekster

- Source code is available at: [GITHUB](https://github.com/Pankaj-dev98/user-management-system-geekster.git)

- Database design: This project only stores user's data as an instance of a linked list (of users) in memory. This list is initialzied at startup as it's a dependency of the controller.

## Data structure used
This prject uses an Instance of LinkedList class but the runtime instance is referenced by List<User> type. This interface is implemented by LinkedList<T> and gives the code better flexibility.

## Project Summary
The endpoints give us means to manage users in a straighforward manner. Users can be easily accessed, updated and deleted with their unique user IDs. Measures have been taken to avoid duplicate user IDs and invalid IDs.


