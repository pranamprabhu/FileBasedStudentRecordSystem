package com.studentrecord;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentRecordSystem system = new StudentRecordSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Record System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Read All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            if (!scanner.hasNextLine()) {
                System.out.println("Input terminated. Exiting...");
                break;
            }
            
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    if (!scanner.hasNextLine()) break;
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    if (!scanner.hasNextLine()) break;
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    if (!scanner.hasNextLine()) break;
                    int age;
                    try {
                        age = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid age.");
                        break;
                    }
                    System.out.print("Enter Grade: ");
                    if (!scanner.hasNextLine()) break;
                    String grade = scanner.nextLine();
                    system.addStudent(new Student(id, name, age, grade));
                    break;
                case 2:
                    List<Student> students = system.readAllStudents();
                    if (students.isEmpty()) {
                        System.out.println("No records found.");
                    } else {
                        System.out.println("\n--- Student Records ---");
                        for (Student s : students) {
                            System.out.println("ID: " + s.getId() + ", Name: " + s.getName() + ", Age: " + s.getAge() + ", Grade: " + s.getGrade());
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter ID to search: ");
                    if (!scanner.hasNextLine()) break;
                    String searchId = scanner.nextLine();
                    Student foundStudent = system.searchStudentById(searchId);
                    if (foundStudent != null) {
                        System.out.println("Found: ID: " + foundStudent.getId() + ", Name: " + foundStudent.getName() + ", Age: " + foundStudent.getAge() + ", Grade: " + foundStudent.getGrade());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter ID of student to update: ");
                    if (!scanner.hasNextLine()) break;
                    String updateId = scanner.nextLine();
                    Student existingStudent = system.searchStudentById(updateId);
                    if (existingStudent != null) {
                        System.out.print("Enter New Name (leave blank to keep current): ");
                        if (!scanner.hasNextLine()) break;
                        String newName = scanner.nextLine();
                        if (newName.isEmpty()) newName = existingStudent.getName();
                        
                        System.out.print("Enter New Age (leave blank to keep current): ");
                        if (!scanner.hasNextLine()) break;
                        String newAgeStr = scanner.nextLine();
                        int newAge = existingStudent.getAge();
                        if (!newAgeStr.isEmpty()) {
                            try {
                                newAge = Integer.parseInt(newAgeStr);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid age, keeping current.");
                            }
                        }
                        
                        System.out.print("Enter New Grade (leave blank to keep current): ");
                        if (!scanner.hasNextLine()) break;
                        String newGrade = scanner.nextLine();
                        if (newGrade.isEmpty()) newGrade = existingStudent.getGrade();
                        
                        system.updateStudent(updateId, new Student(updateId, newName, newAge, newGrade));
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
