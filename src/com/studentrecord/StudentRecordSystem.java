package com.studentrecord;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRecordSystem {
    private static final String FILE_PATH = "students.txt";

    public StudentRecordSystem() {
        ensureFileExists();
    }

    private void ensureFileExists() {
        try {
            Path path = Paths.get(FILE_PATH);
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
        } catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
        }
    }

    public void addStudent(Student student) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(student.toString());
            writer.newLine();
            System.out.println("Student added successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public List<Student> readAllStudents() {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Student student = Student.fromString(line);
                if (student != null) {
                    students.add(student);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        return students;
    }

    public Student searchStudentById(String id) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Student student = Student.fromString(line);
                if (student != null && student.getId().equals(id)) {
                    return student;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        return null;
    }

    public void updateStudent(String id, Student updatedStudent) {
        List<Student> students = readAllStudents();
        boolean found = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                students.set(i, updatedStudent);
                found = true;
                break;
            }
        }
        
        if (found) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, false))) {
                for (Student s : students) {
                    writer.write(s.toString());
                    writer.newLine();
                }
                System.out.println("Student updated successfully.");
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }
}
