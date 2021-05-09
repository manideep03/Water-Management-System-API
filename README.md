# Water-Management-System-API

Water Management System is an online application which gives information about water supply area wise and city wise, user can find the details and send feedback about supply duration, pressure and quality of water. The API also provide real-time information about projects, water awareness.


### Users of the System:
- Admin
- Employee
- User


### Technologies Stack
1. Java (Programming Language)
2. Spring Boot (Application Platform)
3. Spring Data JPA (Data persistence)
4. Hibernate (object–relational mapping tool)
5. MySql (Database)


## Database

This is API using **MySql** database. This is done automatically generated using hibernate.

class diagram:

![database](https://user-images.githubusercontent.com/55098118/117575285-c6e4d780-b0fe-11eb-9f85-8c068483d5f0.png)

## Getting Started

The source code can be checked out to your local and then build and run the application either from your IDE after importing to it as a maven project, or just from a command line. 

Follow these steps for the command-line option:

### Prerequisites
1. Java 8
2. Maven 3
3. Git

### Installing & Running

#### Clone this repo into your local: 

```bash
git clone https://github.com/manideep03/Water-Management-System-API.git
```

####  Build using maven 
	
```
mvn clean install
```
	
#### Start the app
	
```
mvn spring-boot:run
```

API is running on ```localhost:8080```
