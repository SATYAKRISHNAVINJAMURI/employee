CONTENTS OF THIS FILE
---------------------

 * Introduction
 * TECHNOLOGIES USED
 * Requirements
 * Installation
 * Configuration
 * Server Startup
 * Troubleshooting
 * Maintainers
 
 
INTRODUCTION
------------
This Project is for demonstrating role based authorization for employee management.
This is build using Spring Boot technology.

 TECHNOLOGIES USED
------------------
1) Used H2 database for data storage. ( In memory database no extra setup required )
2) Spring Boot for auto configuration and REST APIs.
3) Spring Security for ROLE based authorization.

REQUIREMENTS
------------
1) Java 1.8
2) Maven for dependency management

Installation
------------
1) Clone this project from the git clone url.
2) In the root folder of emplooyee directory execute "mvnw package"
comman so that jar will be generated.

Configuration
------------
1) There should be no services running on port 8080. ( you can modify this in application.properties )
2) As this project uses that port for server installation

Server Startup
------------
1) After running "mvnw package" BUILD SUCCESFULL message
will be displayed.
2) Then you can run this below command for starting the server
by opening the command prompt in target folder which will be in the
employee folder:
"java -jar employee-0.0.1-SNAPSHOT.jar"
3) If the server didn't start, follow the troble shooting guide.

Troubleshooting
------------
1) If server startup failed. Check port no 8080 and stop the
services running over there.
2) If you don't want to do step 1 you can add a line
in the file application.properties at location
employee\src\main\resources\

Modify the line server.port=8081 ( you may use whatever port you want )

Maintainers
------------
Name : Satya Krishna Vinjamuri
contact: 9490537556

