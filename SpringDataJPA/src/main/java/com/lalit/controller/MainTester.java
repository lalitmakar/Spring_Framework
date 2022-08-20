package com.lalit.controller;

import com.lalit.configs.AppConfig;
import com.lalit.models.Employee;
import com.lalit.service.EmployeeService;
import com.lalit.service.EmployeeServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MainTester {

    static Scanner sc = new Scanner(System.in);
    static EmployeeService service;

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        service = ctx.getBean(EmployeeServiceImpl.class);

        int choice = 0;
        do{
            System.out.println("Enter your choice of Operation :");
            System.out.println("1. Add Employee");
            System.out.println("2. Get Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Get All Employee");
            System.out.println("Enter -1 to exit");
            choice = sc.nextInt();
            sc.nextLine(); //to consume the current line-- best workaround is use nextLine() and convert the input into desired data type rather than using nextInt() above this!
            switch (choice){
                case -1 : System.out.println("Good Bye");break;
                case 1 : addEmployee();break;
                case 2 : getEmployee();break;
                case 3 : updateEmployee();break;
                case 4 : deleteEmployee();break;
                case 5 : getAllEmployee();break;
                default : System.out.println("Enter choice between 1 to 5 or -1 to exit");break;
            }
        }while(choice!=-1);

    }


    public static void addEmployee(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("Enter First Name : ");
        String fname = sc.nextLine();
        System.out.println("Enter Middle Name : ");
        String mname = sc.nextLine();
        System.out.println("Enter Last Name : ");
        String lname = sc.nextLine();
        System.out.println("Enter Date Of Birth in dd-mm-yyyy format : ");
        LocalDate date = null;
        while(date==null){
            try{
                date = LocalDate.parse(sc.nextLine(),formatter);
            }catch (DateTimeParseException exp){
                System.out.println("Error in parsing date ... Enter Date Of Birth in dd-mm-yyyy format");
            }
        }

        System.out.println("Entered date is : "+date);
        System.out.println("Enter Email Id : ");
        String email = sc.nextLine();
        System.out.println("Enter Salary : ");
        String sal = sc.nextLine();
        double salary = Double.parseDouble((sal==null || sal=="")? "0" : sal);
        Employee emp = new Employee(fname,mname,lname,date,email,salary);

        int res = service.addEmployee(emp);
        System.out.println("Employee Added Successfully with id : "+res);

    }

    public static void deleteEmployee(){

        System.out.println("Enter Email Id of Employee you want to delete: ");
        String email = sc.nextLine();
        int res = service.deleteEmployee(email);
        if(res>0){
            System.out.println("Employee Deleted Successfully");
        }else{
            System.out.println("Employee with email id didnt exists...");
        }
    }

    public static void getEmployee(){

        System.out.println("Enter Email Id of Employee you want to fetch: ");
        String email = sc.nextLine();
        Employee res = service.getEmployee(email);
        if(res!=null){
            System.out.println("Employee Fetched Successfully");
            System.out.println(res);
        }
        else{
            System.out.println("Employee with email id didnt exists...");
        }
    }

    public static void getAllEmployee(){

        List<Employee> list = service.getAllEmployees();
        if(list!=null){
            System.out.println(list.size()+ " Employees data retrieved..............");
            System.out.println(list);
        }else{
            System.out.println("Table is Empty");
        }

    }

    public  static void updateEmployee(){

        System.out.println("Enter Email Id of Employee you want to update: ");
        String email = sc.nextLine();
        Employee resEmp = service.getEmployee(email);
        if(resEmp!=null){
            System.out.println("Employee retrieved from db is : "+resEmp);
            System.out.println("Enter First Name : ");
            resEmp.setFirstName(sc.nextLine());
            System.out.println("Enter Middle Name : ");
            resEmp.setMiddleName(sc.nextLine());
            System.out.println("Enter Last Name : ");
            resEmp.setLastName(sc.nextLine());
            Employee r = service.updateEmployee(resEmp);
            System.out.println(r);
        }else{
            System.out.println("Employee with email id didnt exists...");
        }

    }

}
