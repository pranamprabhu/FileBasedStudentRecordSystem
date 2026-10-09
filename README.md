# File-Based Student Record System

This is a Java application that simulates a student record management system utilizing File I/O for persistent data storage. It allows you to store, retrieve, update, and search for student records using a text file.

## Features

- **Add Student**: Create a new student record (ID, Name, Age, Grade) and append it to the file.
- **Read All Students**: Retrieve and display all student records currently stored in the file.
- **Search Student by ID**: Look up a specific student by their unique ID.
- **Update Student**: Modify an existing student's details and save the changes back to the file.
- **Graceful Error Handling**: Manages missing files by automatically creating them and handles unexpected input terminations.

## Technologies Used

- **Java**: Core programming language.
- **File I/O**: Uses `BufferedReader` and `BufferedWriter` to handle reading from and writing to a flat text file (`students.txt`).

## How to Compile and Run

1. Open your terminal or command prompt.
2. Navigate to the project directory:
   ```bash
   cd FileBasedStudentRecordSystem
   ```
3. Compile the Java files:
   ```bash
   javac src/com/studentrecord/*.java
   ```
4. Run the application:
   ```bash
   java -cp src com.studentrecord.Main
   ```

## Usage

Once the application is running, you will be presented with a command-line menu:
- Enter `1` to add a new student.
- Enter `2` to view all saved students.
- Enter `3` to search for a student.
- Enter `4` to update an existing student.
- Enter `5` to exit the application.
