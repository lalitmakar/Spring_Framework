package com.lalit.utils;

import com.lalit.models.Employee;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeUtils {

    static Comparator sortByFirstName = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Employee e1 = (Employee) o1;
            Employee e2 = (Employee) o2;
            return e1.getFirstName().compareToIgnoreCase(e2.getFirstName());
        }
    };

    static Comparator getSortByMiddleName = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Employee e1 = (Employee) o1;
            Employee e2 = (Employee) o2;
            return e1.getMiddleName().compareToIgnoreCase(e2.getMiddleName());
        }
    };

    static Comparator getSortByLastName = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Employee e1 = (Employee) o1;
            Employee e2 = (Employee) o2;
            return e1.getLastName().compareToIgnoreCase(e2.getLastName());
        }
    };

    static Comparator getSortByEmailId = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Employee e1 = (Employee) o1;
            Employee e2 = (Employee) o2;
            return e1.getEmailId().compareToIgnoreCase(e2.getEmailId());
        }
    };

    static Comparator getSortByDOB = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Employee e1 = (Employee) o1;
            Employee e2 = (Employee) o2;
            return e1.getDOB().compareTo(e2.getDOB());
        }
    };

    public static void customSortList(List<Employee> employeeList, String sortBy, boolean desc) {
        if(sortBy.equalsIgnoreCase("firstName")){
            Collections.sort(employeeList,desc==false ? sortByFirstName : Collections.reverseOrder(sortByFirstName));
        }else if(sortBy.equalsIgnoreCase("middleName")){
            Collections.sort(employeeList,desc==false ? getSortByMiddleName : Collections.reverseOrder(getSortByMiddleName));
        }else if(sortBy.equalsIgnoreCase("lastName")){
            Collections.sort(employeeList,desc==false ? getSortByLastName : Collections.reverseOrder(getSortByLastName));
        }else if(sortBy.equalsIgnoreCase("emailId")){
            Collections.sort(employeeList,desc==false ? getSortByEmailId : Collections.reverseOrder(getSortByEmailId));
        }else if(sortBy.equalsIgnoreCase("DOB")){
            Collections.sort(employeeList,desc==false ? getSortByDOB : Collections.reverseOrder(getSortByDOB));
        }
    }

}
