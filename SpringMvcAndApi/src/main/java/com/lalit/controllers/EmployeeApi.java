package com.lalit.controllers;

import com.lalit.entities.EmployeeEntity;
import com.lalit.models.Employee;
import com.lalit.services.EmployeeService;
import com.lalit.utils.EmployeeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller    // should have used RestController but just to demonstrate we have used controller
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeApi {

    @Autowired
    EmployeeService service;

    @RequestMapping(value = "/helloWorld")      // ResponseEntity triggers HttpMessageConverter
    public ResponseEntity<String> helloWorld(){
        return ResponseEntity.ok("Hello from Api controller !!!");
    }

    @RequestMapping(value = {"/","/index"})
    @ResponseBody                                                         // triggers HttpMessageConverter
    public ResponseEntity<List<Employee>> homePage(@RequestParam(required = false) String sortBy,@RequestParam(required = false, defaultValue = "false") boolean desc){
        System.out.println("Handler method :homePage() in api is called");
        System.out.println("Sort by : "+sortBy+" ------ DESC :"+desc);
        List<Employee> employeeList = service.getAllEmployees();
        if(sortBy!=null){
            EmployeeUtils.customSortList(employeeList,sortBy,desc);
        }else{
            Collections.reverse(employeeList);
        }
        System.out.println(employeeList);
        return ResponseEntity.ok().body(employeeList);
    }

    @RequestMapping(value = "/getEmployee/{emailId}")
    public ResponseEntity<Employee> getEmployeeByEmailId(@PathVariable("emailId") String emailId){
        System.out.println("Email id from request : "+emailId);
        Employee emp = service.getEmployee(emailId);
        if(emp==null){
            return new ResponseEntity("Employee with email id "+emailId+" not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(emp,HttpStatus.OK);
    }

    @PostMapping(value = "/addEmployee")
    public ResponseEntity<String> addEmployee(@RequestBody Employee emp){
        System.out.println("Employee received from request : "+emp);
        Long id = service.addEmployee(emp);
        return new ResponseEntity("Employee with id "+id+" added successfully",HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteEmployee/{emailId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("emailId") String emailId){
        System.out.println("Email id from request : "+emailId);
        int res = service.deleteEmployee(emailId);
        if(res==-1){
            return new ResponseEntity("Employee with emailId "+emailId+" not found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity("Employee deleted successfully",HttpStatus.OK);
    }

    @RequestMapping(value = "/updateEmployee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp){
        System.out.println("Employee from request : "+emp);
        Employee employeeFetched = service.getEmployee(emp.getEmailId());
        if(employeeFetched==null){
            return new ResponseEntity("Employee could not be found",HttpStatus.NOT_FOUND);
        }
        employeeFetched.setFirstName(emp.getFirstName());
        employeeFetched.setMiddleName(emp.getMiddleName());
        employeeFetched.setLastName(emp.getLastName());
        Employee updatedEmp = service.updateEmployee(employeeFetched);
        return new ResponseEntity<>(updatedEmp,HttpStatus.OK);
    }

}
