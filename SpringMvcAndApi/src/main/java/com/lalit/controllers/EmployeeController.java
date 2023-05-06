package com.lalit.controllers;

import com.lalit.models.Employee;
import com.lalit.services.EmployeeService;
import com.lalit.utils.EmployeeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

@Controller
public class EmployeeController {

    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = {"/","/index"})
    public String homePage(@RequestParam(required = false) String sortBy,@RequestParam(defaultValue = "false",required = false) boolean desc,Model model){
        System.out.println("Sort by : "+sortBy+" ------ DESC :"+desc);
        List<Employee> employeeList = employeeService.getAllEmployees();
        if(sortBy!=null){
            EmployeeUtils.customSortList(employeeList,sortBy,desc);
        }else{
            Collections.reverse(employeeList);
        }
        System.out.println(employeeList);
        model.addAttribute("empList",employeeList);
        return "index";
    }

    @RequestMapping(value = "/addEmployee",method = RequestMethod.GET)
    public String addEmployeePage(){
        return "addEmployee";
    }

    @PostMapping(value = "/addEmployee")
    public String addEmployee(@ModelAttribute Employee employee, BindingResult result){
        System.out.println("EMployee in request : "+employee);
        if(result.hasErrors()){
            return "addEmployee";
        }
        System.out.println("Employee received from request : "+employee);
        Long id = employeeService.addEmployee(employee);
        System.out.println("Employee added with id : "+id);
        return "redirect:/";
    }

    @GetMapping(value = "/updateEmployee/{emailId}")
    public String updateEmployeePage(@PathVariable String emailId, Model model){
        Employee emp = employeeService.getEmployee(emailId);
        if(emp==null){
            return "redirect:/";
        }
        model.addAttribute("emp",emp);
        return "update";
    }

    @PostMapping(value = "/update")
    public String updateEmployee(@ModelAttribute Employee emp, BindingResult result){
        if(result.hasErrors()){
            return "update";
        }

        System.out.println("EMP RECEIVED FOR UPDATE : "+emp);

        Employee employee = employeeService.getEmployee(emp.getEmailId());
        if(employee==null){
            return "redirect:/";
        }
        employee.setFirstName(emp.getFirstName());
        employee.setMiddleName(emp.getMiddleName());
        employee.setLastName(emp.getLastName());

        employee = employeeService.updateEmployee(employee);
        System.out.println("Employee updated : "+employee);
        return "redirect:/";
    }

    @RequestMapping(value = "/deleteEmployee/{emailId}")
    public String deleteEmployee(@PathVariable String emailId){
        int res = employeeService.deleteEmployee(emailId);
        System.out.println("DELETED ? : "+res);
        return "redirect:/";
    }

    @ExceptionHandler(Exception.class)
    public String handleExceptions(Exception exception, Model model){
        model.addAttribute("errorMsg",exception.getMessage());
        return "error";
    }

}
