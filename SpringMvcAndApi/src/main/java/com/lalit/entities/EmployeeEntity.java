package com.lalit.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empId")
    private Long empId;

    @Column(name = "firstName",nullable = false)
    private String firstName;

    @Column(name = "middleName",nullable = false)
    private String middleName;

    @Column(name = "lastName",nullable = false)
    private String lastName;

    @Column(name = "dateOfBirth",nullable = false)
    private LocalDate DOB;

    @Column(name = "emailId",nullable = false,unique = true)
    private String emailId;

    public EmployeeEntity() {
    }

    public EmployeeEntity(String firstName, String middleName, String lastName, LocalDate DOB, String emailId) {
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
        return "EmployeeEntity{" +
                "empId=" + empId +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", DOB=" + DOB +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
