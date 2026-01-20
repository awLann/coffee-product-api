# Coffee Product API

Coffee Product API is a simple **REST API** built using **Spring Boot**, focusing on **backend architecture**, **search functionality**, and **global error handling**. This project is intended as a practice project to demonstrate **best practices in API design**.

## Tech Stack

* Java 17+
* Spring Boot
* Spring Web
* Spring Data JPA
* MySQL
* Maven

## Project Structure

```
coffee-product-api
├── controller        # REST Controllers
├── service           # Business logic
├── repository        # Data access layer
├── entity            # JPA Entities
├── dto
│   └── response      # Response DTOs
├── exception         # Global error handling
└── seeder            # Seeder
```

## API Endpoints

### Get Products

```
GET /api/v1/products
```


### Search Products

```
GET /api/v1/products/search?q={query}
```

Search is performed on the following fields:

* `name`
* `slug`


### Get Product Detail

```
GET /api/v1/products/{slug}
```


## Running the Project

### 1. Clone the Repository

```
git clone <repository-url>
cd coffee-product-api
```

### 2. Configure Environment Variables (.env)

```
DB_URL=YOUR_DB_URL
DB_USERNAME=YOUR_DB_USERNAME
DB_PASSWORD=YOUR_DB_PASSWORD
SERVER_PORT=YOUR_SERVER_PORT
```

### 3. Create the Database

Create a database according to the `DB_URL` defined in the `.env` file, the execute the **coffee_product_schema.sql** script using DBMS.
> Data will be automatically added using seeder script.

### 3. Run the Application

```
mvn spring-boot:run
```

The API will be available at:
```
http://localhost:{SERVER_PORT}
```