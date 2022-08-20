package com.lalit.models;

import java.time.Instant;
import java.time.LocalDate;

public class Employee {

    int id;

    String firstName;

    String middleName;

    String lastName;

    LocalDate DOB;

    double salary;

    String email_id;

    public Employee() {
    }

    public Employee(String firstName, String middleName, String lastName, LocalDate DOB, String email_id) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.email_id = email_id;
    }

    public Employee(String firstName, String middleName, String lastName, LocalDate DOB, String email_id, double salary) {
        this(firstName,middleName,lastName,DOB,email_id);
        this.salary = salary;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", DOB=" + DOB +
                ", salary=" + salary +
                ", email_id='" + email_id + '\'' +
                '}';
    }
}
