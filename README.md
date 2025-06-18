# ⭐ Ratings & Reviews — Full Stack App

---

## 🚀 Working Demo

![Screenshot (197)](https://github.com/user-attachments/assets/ec81c092-2c7e-454b-978a-ddb452b0df2d)
![Screenshot (198)](https://github.com/user-attachments/assets/86ffa4b4-b3c1-4e25-a4ff-a0af992d88ba)


## 🛠️ Tech Stack

- Backend: Spring Boot + REST APIs + JPA (Hibernate)
- Frontend: ReactJS + Axios + CSS
- Database: PostgreSQL


## 1️⃣ Setup PostgreSQL Database

1. Install PostgreSQL → https://www.postgresql.org/download/  

2. Create database:

```sql
CREATE DATABASE ratings_reviews_db;
username: postgres
password: YOUR_PASSWORD
port: 5432


cd ratings-reviews-backend


spring.datasource.url=jdbc:postgresql://localhost:5432/ratings_reviews_db
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8080


./mvnw spring-boot:run
http://localhost:8080/api/products


cd ratings-reviews-frontend
npm install
npm run dev
📝 API Endpoints
Product API
Method	Endpoint	Description
GET	/api/products	List all products
POST	/api/products/add	Add a new product

Review API
Method	Endpoint	Description
GET	/api/reviews	List all reviews
POST	/api/reviews/add	Add a review for product

✅ Features
Add and view products

Rate and review products

Average product rating

Reviews with optional image URL

Responsive UI with React



