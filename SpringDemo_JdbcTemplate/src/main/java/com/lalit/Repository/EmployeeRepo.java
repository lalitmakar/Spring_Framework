package com.lalit.Repository;

import com.lalit.Models.Employee;

import java.util.List;

public interface EmployeeRepo {

    int addEmployee(Employee emp);

    int deleteEmployee(String email_id);

    Employee getEmployee(String email_id);

    Employee updateEmployee(Employee emp);

    List<Employee> getAllEmployees();

}
