# simple-http-api

A simple Java HTTP API implemented using Spring Boot and Maven.

The API exposes a single endpoint that accepts a name and returns a greeting
or an invalid-input response based on the first character of the name.

## How to Run the Application
 
### Prerequisites

- Java 17 or higher
- Maven 3.8 or higher
  
## How to run the Application

From the project root directory, run: mvn spring-boot:run

## How to Run the test

From the project root directory, run: mvn test

## Assumptions

- Name validation is case-insensitive.
- Names starting with A-M are considered valid.
- Names starting with N-Z are considered invalid.
- Missing, empty, or whitespace-only names are considered invalid.
- The name is expected to start with an English alphabetic character.
- Names starting with numbers or special characters are treated as invalid.

