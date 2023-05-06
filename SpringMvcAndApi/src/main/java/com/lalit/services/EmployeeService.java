package com.lalit.services;

import com.lalit.models.Employee;
import java.util.List;

public interface EmployeeService {

    public Long addEmployee(Employee emp);

    public Employee getEmployee(String emailId);

    public List<Employee> getAllEmployees();

    public Employee updateEmployee(Employee emp);

    public int deleteEmployee(String emailId);

}
