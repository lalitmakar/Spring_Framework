package com.lalit.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long employeeId;
    @Column(name = "First_Name")
    String firstName;
    @Column(name = "Last_Name")
    String lastName;
    @Temporal(TemporalType.DATE)
    Date DOB;
    @Column(name = "email_address",unique = true,nullable = false)
    String emailId;
    double salary;

    public EmployeeEntity() {
    }

    public EmployeeEntity(String firstName, String lastName, Date DOB, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.emailId = emailId;
    }

    public EmployeeEntity(String firstName, String lastName, Date DOB, String emailId, double salary) {
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
        return "EmployeeEntity{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", DOB=" + DOB +
                ", emailId='" + emailId + '\'' +
                ", salary=" + salary +
                '}';
    }
}
