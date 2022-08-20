package com.lalit.service;

import com.lalit.entity.EmployeeEntity;
import com.lalit.models.Employee;
import com.lalit.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository repo;

    @Override
    public int addEmployee(Employee emp) {
        EmployeeEntity entity = convertBeanToEntity(emp);
        entity = repo.save(entity);
        return entity.getId();
    }

    @Override
    public int deleteEmployee(String email_id) {
        Employee emp = getEmployee(email_id);
        if(emp!=null){
            repo.delete(convertBeanToEntity(emp));
            return 1;
        }
        return 0;
    }

    @Override
    public Employee getEmployee(String email_id) {
        EmployeeEntity entity = repo.findEmployeeEntityByEmailId(email_id);
        if(entity==null){
            return null;
        }
        return convertEntityToBean(entity);
    }

    @Override
    public Employee updateEmployee(Employee emp) {
        EmployeeEntity entity = repo.save(convertBeanToEntity(emp));
        return convertEntityToBean(entity);
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> listOfEntity = repo.findAll();
        List<Employee> listOfEmployee = new ArrayList<>();
        for(EmployeeEntity entity : listOfEntity){
            listOfEmployee.add(convertEntityToBean(entity));
        }
        return listOfEmployee;
    }

    public EmployeeEntity convertBeanToEntity(Employee empBean){
        EmployeeEntity empEntity = new EmployeeEntity();
        BeanUtils.copyProperties(empBean,empEntity);
        return empEntity;
    }

    public Employee convertEntityToBean(EmployeeEntity entity){
        Employee emp = new Employee();
        BeanUtils.copyProperties(entity,emp);
        return emp;
    }


}
