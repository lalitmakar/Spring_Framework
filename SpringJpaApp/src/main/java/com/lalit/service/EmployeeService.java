package com.lalit.service;

import com.lalit.models.Employee;
import com.lalit.repository.DummyCheckedExp;

import java.util.List;

public interface EmployeeService {

    int addEmployee(Employee emp);

    int addEmloyeeWithCheckedExp(Employee emp) throws DummyCheckedExp;

    int addEmloyeeWithReadOnlyMode(Employee emp);

    int addEmloyeeWithUnCheckedExp(Employee emp);

    int deleteEmployee(String email_id);

    Employee getEmployee(String email_id);

    Employee updateEmployee(Employee emp);

    List<Employee> getAllEmployees();

}
