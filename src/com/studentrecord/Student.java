package com.studentrecord;

import java.io.Serializable;

public class Student implements Serializable {
    private String id;
    private String name;
    private int age;
    private String grade;

    public Student(String id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + grade;
    }

    public static Student fromString(String line) {
        String[] parts = line.split(",");
        if (parts.length == 4) {
            return new Student(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3]);
        }
        return null;
    }
}
