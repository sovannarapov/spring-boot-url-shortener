# URL Shortener Service

A Spring Boot application that provides URL shortening functionality with a clean architecture and RESTful API endpoints.

## Architecture

### Project Structure

```
url-shortener/
├── src/main/java/com/sovannara/urlshortener/
│   ├── config/            # Configuration classes
│   ├── controllers/       # REST controllers
│   ├── dtos/             # Data Transfer Objects
│   ├── entities/         # JPA entities
│   ├── exceptions/       # Custom exceptions
│   ├── models/           # Response models
│   ├── repositories/     # Data access layer
│   ├── services/         # Business logic
│   └── utils/            # Utility classes
```

### Tech Stack

- Java 21
- Spring Boot 3.4.4
- PostgreSQL
- Maven
- JPA/Hibernate
- Lombok

## Features

- URL shortening with custom code generation
- Redirect service for shortened URLs
- Input validation
- Error handling
- Database persistence
- RESTful API endpoints

## API Endpoints

### Create Short URL

```http
POST /api/url/create
Content-Type: application/json

{
    "url": "https://example.com/very/long/url"
}
```

Response:

```json
{
  "success": true,
  "statusCode": "200 OK",
  "message": "Successfully",
  "data": {
    "shortUrl": "http://localhost:9090/api/url/Ab3Cd4E"
  }
}
```

### Redirect to Original URL

```http
GET /api/url/{code}
```

## Setup and Installation

1. Clone the repository:

```bash
git clone https://github.com/yourusername/url-shortener.git
```

2. Configure PostgreSQL:

- Create a database named `url-shorten-app`
- Update `application.yml` with your database credentials if needed

3. Build the project:

```bash
./mvnw clean install
```

4. Run the application:

```bash
./mvnw spring-boot:run
```

The service will be available at `http://localhost:9090`

## Configuration

Application properties can be modified in `src/main/resources/application.yml`:

```yaml
server:
  port: 9090

spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/url-shorten-app
    username: postgres
    password: postgres

application:
  base-url: http://localhost:9090
  prefix: /api
```

## Error Handling

The service includes comprehensive error handling for:

- Invalid URLs
- Not found URLs
- Server errors

## Security Considerations

- Input validation for URLs
- Unique code generation
- Database indexing for efficient lookups
