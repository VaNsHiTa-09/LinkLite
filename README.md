# LinkLite - URL Shortener Service

A scalable URL Shortener built using **Java, Spring Boot, and Redis** that generates compact Base62 encoded URLs, supports automatic URL expiration using Redis TTL, and tracks click analytics in real time.

---

## Features

* Generate unique short URLs using Base62 encoding
* Fast URL storage and retrieval using Redis
* Automatic URL expiration using Redis TTL
* Real-time click analytics
* URL validation before shortening
* Global exception handling
* RESTful API architecture
* Layered architecture (Controller → Service → Repository)

---

## 🛠️ Tech Stack

* Java 17
* Spring Boot
* Spring Web
* Spring Data Redis
* Redis
* Gradle
* Postman

---

## 📂 Project Structure

```
src
 ├── controller
 ├── service
 ├── repository
 ├── dto
 ├── exception
 ├── util
 └── config
```

---

## API Endpoints

### Shorten URL

**POST**

```
/api/urls/shorten
```

Request

```json
{
    "url":"https://google.com"
}
```

Response

```json
{
    "shortUrl":"http://localhost:8080/qi"
}
```

---

### Redirect URL

**GET**

```
/qi
```

Redirects the user to the original URL.

---

### URL Analytics

**GET**

```
/api/urls/stats/{shortCode}
```

Response

```json
{
    "shortCode":"qi",
    "originalUrl":"https://google.com",
    "clicks":5
}
```

---

## How to Run

### Clone Repository

```bash
git clone https://github.com/VanShiTa-09/LinkLite.git
```

### Start Redis

```bash
brew services start redis
```

### Run Application

```bash
./gradlew bootRun
```

Application will start on

```
http://localhost:8080
```

---

##  Example Workflow

```
Original URL
        │
        ▼
POST /api/urls/shorten
        │
        ▼
Short URL Generated
        │
        ▼
GET /{shortCode}
        │
        ▼
Redirect to Original URL
        │
        ▼
Click Count Updated
```

---

## Concepts Implemented

* Spring Boot
* REST APIs
* Redis Integration
* Base62 Encoding
* Repository Pattern
* Layered Architecture
* DTO Pattern
* URL Validation
* Global Exception Handling
* Redis TTL
* Click Analytics

---

## Author

**Vanshita**

GitHub: https://github.com/VanShiTa-09
