# Test Project
This is a Java Selenium TestNG Project

## Installation
Please install [java 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) and add to your path
Please install [maven](https://maven.apache.org/download.cgi) and add to your path

## Usage
Open the command line and go to the project user directory (same directory as the pom - i.e. C:\Users\<user>\app\dev2\test) and execute the following:
```java
mvn clean compile exec:java test -Dexec.mainClass="com.postman.main.Postman" -Dpackage="com.postman.test.selenium" -Dbrowser=chrome

## Note
Please make sure your Chrome version is up to date (v87)
