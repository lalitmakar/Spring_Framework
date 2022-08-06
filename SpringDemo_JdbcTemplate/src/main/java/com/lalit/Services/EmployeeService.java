package com.lalit.Services;

import com.lalit.Models.Employee;

import java.util.List;

public interface EmployeeService {

    int addEmployee(Employee emp);

    int deleteEmployee(String email_id);

    Employee getEmployee(String email_id);

    Employee updateEmployee(Employee emp);

    List<Employee> getAllEmployees();

}
