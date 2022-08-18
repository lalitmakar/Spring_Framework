package com.lalit.repository;

import com.lalit.models.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository {

    int addEmployee(Employee emp);

    int addEmloyeeWithCheckedExp(Employee emp) throws DummyCheckedExp;

    int addEmloyeeWithReadOnlyMode(Employee emp);

    int addEmloyeeWithUnCheckedExp(Employee emp);

    int deleteEmployee(String email_id);

    Employee getEmployee(String email_id);

    Employee updateEmployee(Employee emp);

    List<Employee> getAllEmployees();


}
