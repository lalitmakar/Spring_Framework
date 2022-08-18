package com.lalit.models;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.Date;

public class Employee {

    Long employeeId;
    String firstName;
    String lastName;
    Date DOB;
    String emailId;
    double salary;

    public Employee() {
    }

    public Employee(String firstName, String lastName, Date DOB, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.emailId = emailId;
    }

    public Employee(String firstName, String lastName, Date DOB, String emailId, double salary) {
        this(firstName,lastName,DOB, emailId);
        this.salary = salary;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", DOB=" + DOB +
                ", emailId='" + emailId + '\'' +
                ", salary=" + salary +
                '}';
    }
}
