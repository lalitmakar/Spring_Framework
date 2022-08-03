package com.lalit.Services;

import com.lalit.Models.Employee;
import com.lalit.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    @Autowired
    EmployeeRepo repo;

    @Override
    public int addEmployee(Employee emp) {
        return repo.addEmployee(emp);
    }

    @Override
    public int deleteEmployee(String email_id) {
        return repo.deleteEmployee(email_id);
    }

    @Override
    public Employee getEmployee(String email_id) {
        return repo.getEmployee(email_id);
    }

    @Override
    public Employee updateEmployee(Employee emp) {
        return repo.updateEmployee(emp);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repo.getAllEmployees();
    }
}
