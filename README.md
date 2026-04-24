# Digital Queue Management System

## Author

Monisha G

---

## Project Description

The Digital Queue Management System is a desktop application developed using Java Swing, JDBC, and MySQL. It manages customer queues by generating tokens, tracking status, and serving customers in order.

---

## Features

* Add customers to queue
* Automatic token generation
* View queue in table format
* Serve next customer
* Status tracking (WAITING / SERVED)

---

## Technologies Used

* Java (Swing for GUI)
* JDBC (Java Database Connectivity)
* MySQL (Database)

---

## Database Setup

```sql
CREATE DATABASE queue_system;
USE queue_system;

CREATE TABLE queue (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    service VARCHAR(50),
    token_number INT,
    status VARCHAR(20)
);
```

---

## Project Structure

QueueSystem/
│── DBConnection.java
│── QueueDAO.java
│── QueueUI.java

---

## How to Run

1. Install MySQL and create the database
2. Update database username and password in DBConnection.java
3. Add MySQL Connector JAR file to the project
4. Compile and run QueueUI.java

---

## Usage

1. Enter customer name and service
2. Click "Add to Queue"
3. System generates a token number
4. Click "Serve Next" to update status
5. View queue in the table

---

## Sample Output

| ID | Name   | Service          | Token | Status  |
| -- | ------ | ---------------- | ----- | ------- |
| 1  | Rahul  | Billing          | 1     | WAITING |
| 2  | Anjali | Customer Support | 2     | SERVED  |

---

## Future Enhancements

* Admin login system
* Delete or update customer
* Priority queue handling
* Search functionality

---

## Notes

* Ensure MySQL server is running before executing the project
* Use correct JDBC driver (MySQL Connector/J)
* Modify database credentials as required

---

## License

This project is for educational purposes only.
