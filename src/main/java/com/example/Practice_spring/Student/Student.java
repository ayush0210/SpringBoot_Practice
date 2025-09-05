package com.example.Practice_spring.Student;

import jakarta.persistence.*;

import java.text.DateFormat;
import java.time.LocalDate;

@Entity
@Table(name = "Student")
public class Student {

    public Student() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    private LocalDate dob;

    public Student(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    private LocalDate enrollmentDate = LocalDate.now();

    private boolean isActive;

    public Student(Long id, String firstName, String lastName, String email, LocalDate dob, boolean isActive) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
