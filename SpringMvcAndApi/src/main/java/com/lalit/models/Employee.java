package com.lalit.models;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

public class Employee {

    private Long empId;
    private String firstName;
    private String middleName;
    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd") // this is the format of date in incoming request
    private LocalDate DOB;
    private String emailId;

    public Employee() {
    }

    public Employee(String firstName, String middleName, String lastName, LocalDate DOB, String emailId) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.emailId = emailId;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", DOB=" + DOB +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
