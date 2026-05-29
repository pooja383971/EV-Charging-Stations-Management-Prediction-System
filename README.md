# 🚗 EV Charging Stations Management & Prediction System

## 📖 Overview

The **EV Charging Stations Management & Prediction System** is a web-based application developed to help electric vehicle (EV) users efficiently locate, manage, and analyze charging stations. The platform provides station management features, charging cost calculation, and an interactive user interface to improve EV charging decisions.

The project is built using **Spring Boot**, **Java**, **H2 Database**, and **Docker**, demonstrating modern full-stack development and containerized deployment.

---

## ✨ Features

* View available EV charging stations
* Add new charging stations
* Calculate charging costs
* Manage charging station information
* Store station data using H2 Database
* Responsive and user-friendly interface
* Dockerized deployment for portability and scalability

---

## 🛠️ Technology Stack

### Frontend

* HTML
* CSS
* JavaScript

### Backend

* Java
* Spring Boot
* Maven

### Database

* H2 Database

### Deployment & DevOps

* Docker
* Docker Desktop

---

## 📂 Project Structure

```text
EV-Charging-Stations-Management-Prediction-System
│
├── src/
├── data/
├── target/
├── Dockerfile
├── pom.xml
├── mvnw
├── .gitignore
└── README.md
```

---

## ⚙️ Installation & Setup

### Clone Repository

```bash
git clone https://github.com/YOUR_USERNAME/EV-Charging-Stations-Management-Prediction-System.git
cd EV-Charging-Stations-Management-Prediction-System
```

### Run Using Maven

```bash
mvn spring-boot:run
```

Application will start at:

```text
http://localhost:8080
```

---

## 🐳 Docker Deployment

### Build Docker Image

```bash
docker build -t ev-charging-app .
```

### Run Docker Container

```bash
docker run -d -p 8081:8080 --name ev-charging-container ev-charging-app
```

### Access Application

```text
http://localhost:8081
```

---

## 🔄 Application Workflow

```text
User
  │
  ▼
Web Interface
  │
  ▼
Spring Boot Backend
  │
  ▼
H2 Database
  │
  ▼
Charging Station Data Processing
  │
  ▼
Results Displayed to User
```

---

## 📸 Screenshots

### Home Page

(Add Screenshot Here)

### Stations Page

(Add Screenshot Here)

### Add Station

(Add Screenshot Here)

### Charging Cost Calculator

(Add Screenshot Here)

### Docker Deployment

(Add Screenshot Here)

---

## 🎯 Project Objectives

* Simplify EV charging station management
* Provide charging cost estimation
* Demonstrate full-stack application development
* Showcase Docker containerization and deployment
* Support future expansion with predictive analytics

---

## 🚀 Future Enhancements

* Real-time charging station availability
* AI-based charging demand prediction
* Google Maps integration
* User authentication and authorization
* Cloud deployment on Azure or AWS
* Mobile application support

---

## 💡 Key Learning Outcomes

* Spring Boot application development
* Database integration using H2
* RESTful architecture concepts
* Docker image creation and container deployment
* Software deployment and testing

---

## 👨‍💻 Author

**Pooja Kumari**

B.Tech Student

---

## 📄 License

This project is created for educational and academic purposes only.
