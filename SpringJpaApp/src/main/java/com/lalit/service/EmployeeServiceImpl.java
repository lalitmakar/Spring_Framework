package com.lalit.service;

import com.lalit.models.Employee;
import com.lalit.repository.DummyCheckedExp;
import com.lalit.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public int addEmployee(Employee emp) {
        return employeeRepository.addEmployee(emp);
    }

    @Override
    public int addEmloyeeWithCheckedExp(Employee emp) throws DummyCheckedExp {
        return employeeRepository.addEmloyeeWithCheckedExp(emp);
    }

    @Override
    public int addEmloyeeWithReadOnlyMode(Employee emp) {
        return employeeRepository.addEmloyeeWithReadOnlyMode(emp);
    }

    @Override
    public int addEmloyeeWithUnCheckedExp(Employee emp) {
        return employeeRepository.addEmloyeeWithUnCheckedExp(emp);
    }

    @Override
    public int deleteEmployee(String email_id) {
        return employeeRepository.deleteEmployee(email_id);
    }

    @Override
    public Employee getEmployee(String email_id) {
        return employeeRepository.getEmployee(email_id);
    }

    @Override
    public Employee updateEmployee(Employee emp) {
        return employeeRepository.updateEmployee(emp);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }
}
