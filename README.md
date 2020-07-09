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

### 3) Add some sample data to database
    -- Connect to database --
    docker exec -it "container id" /bin/bash
    psql -U postgres
    
    -- Use database --
    \c bookstoredb
    
    -- Insert sample data --
    INSERT INTO book (id, title, author) VALUES (uuid_generate_v4(), 'Anna Karenina', 'Lew Tolstoi');
    INSERT INTO book (id, title, author) VALUES (uuid_generate_v4(), 'Hacking: The Art of Exploitation', 'Jon Erickson');
    
### 4) Postman example
    -- GET all books --
    http://localhost:8080/api/v1/book
    
    -- Get book by id --
    http://localhost:8080/api/v1/book/12396c8c-15db-42c0-9467-379b1826755c (sample uuid)
    
    
### 5) Endpoints

#### Greeting endpoints
- /
- /api/hello
- /api/hello?name="a_sample_name" (without quotes)

####Book endpoints
- /api/v1/book
- /api/v1/book/"book_id" (without quotes)

