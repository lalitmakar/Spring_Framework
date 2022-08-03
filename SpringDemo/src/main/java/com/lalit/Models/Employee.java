package com.lalit.Models;

import java.util.Date;

public class Employee {

    int id;
    String first_name;
    String middle_name;
    String last_name;
    Date DOJ;

    String email_id;

    public Employee(String first_name, String middle_name, String last_name, Date DOJ,String email_id) {
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.DOJ = DOJ;
        this.email_id = email_id;
    }

    public Employee() {

    }

    public String getEmail_id() {
        return email_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getDOJ() {
        return DOJ;
    }

    public void setDOJ(Date DOJ) {
        this.DOJ = DOJ;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "first_name='" + first_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", DOJ=" + DOJ +
                ", email_id='" + email_id + '\'' +
                '}';
    }
}
