package com.lalit.controllers;

import com.lalit.appConfigs.AppConfig;
import com.lalit.models.Employee;
import com.lalit.repository.DummyCheckedExp;
import com.lalit.service.EmployeeService;
import com.lalit.service.EmployeeServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.Date;

public class MainTester {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeService service = ctx.getBean(EmployeeServiceImpl.class);

//        int res = service.addEmployee(new Employee("LLL","Suthar", new Date(),"lalitS@gmail.com",900000));
//        int res = service.addEmloyeeWithUnCheckedExp(new Employee("LLL","Suthar", new Date(),"lalitCheckedLatest@gmail.com",900000));
//        System.out.println(res);

//        int res = 0;
//        try {
//            res = service.addEmloyeeWithCheckedExp(new Employee("LLL","Suthar", new Date(),"lalitCheckedNEW@gmail.com",900000));
//        } catch (DummyCheckedExp e) {
//            throw new RuntimeException(e);
//        }

        int res = service.addEmloyeeWithReadOnlyMode(new Employee("LLL","Suthar", new Date(),"lalitREADNEW@gmail.com",900000));

        System.out.println(res);



//        Employee emp = service.getEmployee("l@gm.com");
//        System.out.println(emp);

//        service.deleteEmployee("l@gmail.com");

//        service.getAllEmployees();

//        Employee emp = service.getEmployee("lalitS@gmail.com");
//        emp.setFirstName("Lalit");
//        emp.setLastName("Makar");
//        emp.setDOB(new Date());
//        service.updateEmployee(emp);
    }

}

//org.springframework.dao.EmptyResultDataAccessException: No entity found for query;  transa
