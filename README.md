
---

# 🏠 Interior Design Office System

## 📌 Overview

The **Interior Design Office System** is a Java-based desktop application designed to manage an interior design business.
It allows clients to create design requests, employees to manage designs, and managers to control the system through an admin dashboard.

The system integrates:

* Object-Oriented Programming (OOP)
* Graphical User Interface (GUI) using Swing
* Database management using SQL

---

## 🚀 Features

### 👤 User Management

* User registration and login system
* Supports different roles:

  * Customer
  * Employee
  * Manager
* Authentication is handled through the database 

---

### 🎨 Design Management

* Create different design types:

  * Classic
  * Modern
  * Rustic
  * Custom designs
* Each design includes:

  * Name
  * Cost
  * Features
  * Description
* Designs are stored and retrieved from the database 

---

### 💰 Pricing System

* Two pricing strategies:

  * Regular Design Pricing
  * Creative Design Pricing
* Supports:

  * Discounts
  * Extra features
  * Premium support
* Final price is calculated dynamically 

---

### 🧑‍💼 Employee System

* Employees can:

  * Handle designs
  * Track income
  * Level up based on performance
* Manager can:

  * View all employees
  * Assign tasks

---

### 📊 Admin Dashboard

* Full database control (CRUD operations):

  * View tables
  * Insert data
  * Update records
  * Delete records
* Import data from CSV/Excel files
* Dynamic table loading from database 

---

### 🖥️ GUI (User Interface)

* Built باستخدام **Java Swing**
* يحتوي على:

  * Login / Sign Up screens
  * Design selection screens
  * Pricing view
  * Employee selection
  * Admin dashboard

---

## 🛠️ Technologies Used

* Java (OOP)
* Java Swing (GUI)
* SQL Database (JDBC)
* NetBeans IDE

---

## 📂 Project Structure

```
📁 interiordesignproject1
 ├── Design.java
 ├── Interiordesignproject1.java
 ├── Price.java
 ├── UserDetails.java
 └── oop2project.sql
```

---

## ⚙️ How to Run

1. Open the project in NetBeans or any Java IDE
2. Make sure the database is connected (DBConnection class)
3. Import the SQL file:

   ```
   oop2project.sql
   ```
4. Run:

   ```
   Interiordesignproject1.java
   ```

---

## 🧠 OOP Concepts Used

* Inheritance (Design → subclasses, User → Employee/Customer)
* Polymorphism (Price calculation)
* Encapsulation (private fields + getters/setters)
* Abstraction (abstract class Price)

---

## 📌 Notes

* The system uses JDBC for database connectivity
* Manager access requires a password
* Data is dynamically loaded from the database

---

## 👩‍💻 Author

Developed as part of an **OOP course project**.

---
