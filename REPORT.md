# Technical Report: File-Based Student Record System

## 1. Introduction
The **File-Based Student Record System** is a Java application designed to manage student data using flat-file storage. The primary objective of this project is to demonstrate an understanding of Java File I/O mechanisms, specifically using `BufferedReader` and `BufferedWriter`, and to implement a persistent storage solution for a basic CRUD application without relying on a database.

## 2. System Architecture & Design
The system follows a simple console-based architecture and is divided into three main components:
- **`Student.java`**: A model class representing the data structure of a student. It encapsulates fields such as `id`, `name`, `age`, and `grade`. It also includes utility methods to serialize the object into a comma-separated string for storage and deserialize a string back into a `Student` object.
- **`StudentRecordSystem.java`**: The core service class responsible for all File I/O operations. It manages the reading and writing of the `students.txt` file and handles the logic for adding, searching, and updating records.
- **`Main.java`**: The entry point of the application, providing an interactive command-line interface (CLI) for the user. It captures user inputs and delegates actions to the `StudentRecordSystem`.

## 3. Implementation Details
### 3.1 Data Storage Format
Data is stored persistently in a plain text file (`students.txt`). Each line in the file represents a single student record, with fields separated by commas (CSV format):
```text
[ID],[Name],[Age],[Grade]
```
Example: `101,John Doe,20,A`

### 3.2 File I/O Mechanisms
- **Writing Data**: `BufferedWriter` wrapped around a `FileWriter` is used for writing. When adding a new student, the `FileWriter` is instantiated with the `append` flag set to `true`, ensuring new records are added to the end of the file without overwriting existing data.
- **Reading Data**: `BufferedReader` wrapped around a `FileReader` is used to read the file line by line. The `readLine()` method efficiently streams the data into memory, which is then parsed into `Student` objects.
- **Updating Data**: Since modifying a specific line in a flat file directly can be complex, the update operation reads all records into a temporary in-memory list, modifies the targeted record, and then overwrites the entire file with the updated list using a non-appending `FileWriter`.

### 3.3 Error Handling
- **Missing Files**: The system proactively checks if `students.txt` exists at startup using `java.nio.file.Files`. If the file is missing, it is automatically created to prevent `FileNotFoundException` crashes.
- **Input Validation**: The CLI includes `try-catch` blocks to gracefully handle `NumberFormatException` if a user inputs non-numeric characters for fields like age or choice selection. It also checks `Scanner.hasNextLine()` to handle unexpected input terminations gracefully.

## 4. Conclusion
This project successfully fulfills the requirement of building a file-based record system. It provides a robust, lightweight, and database-independent way to store and manage student information, while serving as an effective demonstration of Java's standard input/output libraries and error-handling best practices.
