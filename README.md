# Employee Management System

A simple Java-based Employee Management System that allows users to perform CRUD (Create, Read, Update, Delete) operations on employee data. The system supports functionalities such as saving employee details, verifying employees, updating employee information, and deleting employee records.

## Features

- **Save Employee Details**: Add a new employee with their ID, name, phone number, email, and password.
- **Verify Employee**: Authenticate employees using email/password or phone number/password.
- **Update Employee Details**: Modify employee details like name, phone number, email, and password.
- **Delete Employee Details**: Remove an employee's record from the system using their ID.

## Technologies Used

- **Java**: The core language used for building the system.
- **JDBC**: For database connectivity and performing SQL operations.
- **MySQL**: Database used to store employee records.
- **Properties File**: Configuration of database connection details.

## Getting Started

### Prerequisites

- Java (JDK 8 or higher) installed on your machine.
- MySQL server running with a database called `employee` (you can change this in the `jdbc.properties` file).

### Setting Up

1. Clone the repository:
   ```bash
   git clone https://github.com/Ganesh-M-hash/EmployeeManagementSystem.git
