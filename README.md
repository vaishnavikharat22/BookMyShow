# BookMyShow - Movie Ticket Booking System

A Spring Boot REST API application for booking movie tickets. This system allows users to view movies, shows, theaters, select seats, and make bookings and payments.

## Project Overview

BookMyShow is a backend application built with **Spring Boot 4.0.2** that manages:
- **Users** - User registration and management
- **Theaters** - Theater location and details
- **Movies** - Movie catalog
- **Shows** - Movie show timings
- **Screens** - Theater screens
- **Seats** - Seat availability and management
- **Bookings** - Ticket reservations
- **Payments** - Payment processing

## Tech Stack

- **Framework**: Spring Boot 4.0.2
- **Java Version**: Java 21
- **Database**: MySQL
- **ORM**: Spring Data JPA with Hibernate
- **Build Tool**: Maven
- **Additional Libraries**: Lombok (for reducing boilerplate code)

## Prerequisites

Before running the application, ensure you have:
- **Java 21** or higher installed
- **Maven 3.6+** installed
- **MySQL Server** running
- MySQL database created with appropriate credentials

## Project Structure

```
bms/
├── src/main/java/com/cfs/bms/
│   ├── BmsApplication.java           # Main Spring Boot application
│   ├── controller/
│   │   └── BookingController.java     # REST endpoints for bookings
│   ├── service/
│   │   └── BookingService.java        # Business logic layer
│   ├── repository/                    # Data access layer (Spring Data JPA)
│   │   ├── BookingRepository.java
│   │   ├── MovieRepository.java
│   │   ├── PaymentRepository.java
│   │   ├── ScreenRepository.java
│   │   ├── ShowRepository.java
│   │   ├── ShowSeatRepository.java
│   │   ├── TheaterRepository.java
│   │   └── UserRepository.java
│   ├── model/                         # Entity classes
│   │   ├── Booking.java
│   │   ├── Movie.java
│   │   ├── Payment.java
│   │   ├── Screen.java
│   │   ├── Seat.java
│   │   ├── Show.java
│   │   ├── ShowSeat.java
│   │   ├── Theater.java
│   │   └── User.java
│   ├── dto/                           # Data Transfer Objects
│   │   ├── BookingDto.java
│   │   ├── BookingRequestDto.java
│   │   ├── MovieDto.java
│   │   ├── PaymentDto.java
│   │   ├── ScreenDto.java
│   │   ├── SeatDto.java
│   │   ├── ShowDto.java
│   │   ├── ShowSeatDto.java
│   │   ├── TheaterDto.java
│   │   └── UserDto.java
│   └── exception/                     # Custom exception handling
│       ├── ErrorResponse.java
│       ├── GlobalExceptionHandler.java
│       ├── ResourceNotFoundException.java
│       └── SeatUnavailableException.java
├── src/main/resources/
│   └── application.properties          # Application configuration
├── src/test/java/                      # Test classes
├── pom.xml                             # Maven configuration
└── README.md                           # This file
```

## Installation & Setup

### 1. Clone the Repository
```bash
git clone <repository-url>
cd bms
```

### 2. Configure Database
Edit `src/main/resources/application.properties` and update the database credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bookmyshow
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Build the Project
```bash
mvn clean install
```

### 4. Run the Application
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080` (or as configured in application.properties).

## API Endpoints

### Bookings
- **POST** `/api/bookings` - Create a new booking
  - Request: `BookingRequestDto`
  - Response: `BookingDto`

## Entity Relationships

- **User** → Multiple Bookings
- **Theater** → Multiple Screens
- **Movie** → Multiple Shows
- **Show** → Multiple ShowSeats
- **Screen** → Multiple Seats
- **Booking** → Multiple ShowSeats (selected seats)
- **Booking** → Payment (payment info)

## Exception Handling

The application includes global exception handling with custom exceptions:
- `ResourceNotFoundException` - When a resource is not found
- `SeatUnavailableException` - When a seat is already booked
- `GlobalExceptionHandler` - Centralized exception handling

## Error Response Format

```json
{
  "message": "Error message",
  "timestamp": "2025-02-07T10:30:00",
  "status": 404
}
```

## Key Features

- ✅ User management
- ✅ Theater and seat management
- ✅ Movie catalog with shows
- ✅ Seat availability tracking
- ✅ Ticket booking system
- ✅ Payment processing
- ✅ Custom exception handling
- ✅ RESTful API design
- ✅ Data validation using DTOs

## Development Notes

- The project uses **Lombok** to reduce boilerplate code (getters, setters, constructors)
- **Spring Data JPA** provides repository interfaces for database operations
- **DTOs** are used to separate API contracts from database entities
- **Global Exception Handler** ensures consistent error responses

## Future Enhancements

- Add authentication & authorization (Spring Security)
- Implement search and filtering APIs
- Add payment gateway integration
- Implement seat layout visualization
- Add notification system (email/SMS)
- Implement caching mechanisms
- Add comprehensive test coverage
- API documentation with Swagger/SpringFox

## Troubleshooting

### Database Connection Issues
- Ensure MySQL server is running
- Verify database URL, username, and password in `application.properties`
- Ensure the database exists or `ddl-auto=create` is set for auto-creation

### Port Already in Use
- Change the port in `application.properties`: `server.port=8081`

### Build Failures
- Clear Maven cache: `mvn clean install`
- Ensure Java 21 is being used: `java -version`

## License

This project is provided as-is for educational and development purposes.

## Contact & Support

For issues, questions, or contributions, please contact the development team.
