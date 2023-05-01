package com.lalit.services;

import com.lalit.entities.EmployeeEntity;
import com.lalit.models.Employee;
import com.lalit.repositories.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Long addEmployee(Employee emp) {
        if(emp!=null){
            EmployeeEntity entity = employeeRepository.save(convertBeanToEntity(emp));
            return entity.getEmpId();
        }
        return null;
    }

    @Override
    public Employee getEmployee(String emailId) {
        EmployeeEntity entity = employeeRepository.findByEmailId(emailId);
        if(entity!=null)
            return convertEntityToBean(entity);
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> listOfEntity = employeeRepository.findAll();
        System.out.println("List of employee entities : "+listOfEntity);
        List<Employee> listOfEmployees = new ArrayList<>();
        for(EmployeeEntity entity : listOfEntity){
            Employee emp = convertEntityToBean(entity);
            listOfEmployees.add(emp);
        }
        return listOfEmployees;
    }

    @Override
    public Employee updateEmployee(Employee emp) {
        if(emp!=null){
            EmployeeEntity entity = employeeRepository.save(convertBeanToEntity(emp));
            return convertEntityToBean(entity);
        }
        return null;
    }

    @Override
    public int deleteEmployee(String emailId) {
        EmployeeEntity entity = employeeRepository.findByEmailId(emailId);
        if(entity!=null){
            employeeRepository.delete(entity);
            return 0;
        }
        return -1;
    }

    public Employee convertEntityToBean(EmployeeEntity entity){
        Employee empbean = new Employee();
        BeanUtils.copyProperties(entity,empbean);
        return empbean;
    }

    public EmployeeEntity convertBeanToEntity(Employee empBean){
        EmployeeEntity entity = new EmployeeEntity();
        BeanUtils.copyProperties(empBean,entity);
        return entity;
    }
}
