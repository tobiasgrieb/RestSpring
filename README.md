# RestSpring

### Requirements
- Docker Compose
(https://docs.docker.com/compose/install/)
- Postgres using docker (https://hub.docker.com/_/postgres/)
- Postman (https://www.postman.com/)
- Maven (https://maven.apache.org/install.html)

### 1) Create database using docker
    -- Create docker image and connect to it --
    docker run --name bookstore -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres:alpine
    docker exec -it "container id" /bin/bash
    psql -U postgres
    
    -- Create database --
    CREATE DATABASE bookstoredb;
    
    -- Install extension for uuid --
    CREATE EXTENSION IF NOT EXISTS "uuid-ossp"; 
    
### 2) Run application
### 2.1) With docker-compose (WIP - not working yet)

#### Create jar files
    cd ~/RestSpring/backend
    mvn clean package spring-boot:repackage

#### Build image
    cd ~/RestSpring
    docker-compose build
    docker-compose up -d (run in the background)

Application running on http://localhost:8080

### 2.2) Without docker
Run the application using your IDE
    
### 3) Postman example
    -- ADD a book --
    POST: http://localhost:8080/api/v1/book
        JSON: {
              "title": "Hacking: The Art of Exploitation",
              "author": "Jon Erickson"
              }
              
    -- GET all books --
    GET: http://localhost:8080/api/v1/book
    
    -- Get book by id --
    GET: http://localhost:8080/api/v1/book/12396c8c-15db-42c0-9467-379b1826755c (sample uuid)
    
    
### 4) Endpoints

#### Greeting endpoints
- /
- /api/hello
- /api/hello?name=<a_sample_name>

#### Book endpoints
- /api/v1/book
- /api/v1/book/<book_id>

