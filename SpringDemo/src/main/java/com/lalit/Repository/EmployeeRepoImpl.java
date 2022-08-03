package com.lalit.Repository;

import com.lalit.Models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepoImpl implements  EmployeeRepo{

    @Autowired
    DriverManagerDataSource dataSource;

    @Override
    public int addEmployee(Employee emp) {

        int res = 0;
        try {
            Connection conn = dataSource.getConnection();
            String query = "INSERT INTO EMPLOYEE VALUES (DEFAULT,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,emp.getFirst_name());
            stmt.setString(2,emp.getMiddle_name());
            stmt.setString(3,emp.getLast_name());
            stmt.setDate(4,emp.getDOJ()==null ? new Date(new java.util.Date().getTime()) : new Date(emp.getDOJ().getTime()));
            stmt.setString(5,emp.getEmail_id());

            res = stmt.executeUpdate();
            System.out.println("Number of rows updated : "+res);
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error occured while adding Employee.......");
        }
        return res;
    }

    @Override
    public int deleteEmployee(String email_id) {
        int res = -1;
        try {
            Connection conn = dataSource.getConnection();

            String query = "DELETE FROM EMPLOYEE where email_id=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,email_id);
            res = stmt.executeUpdate();
            System.out.println("Number of rows updated : "+res);
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error occured while deleting Employee.......");
        }

        return res;
    }

    @Override
    public Employee getEmployee(String email_id) {

        Employee emp = null;
        try {
            Connection conn = dataSource.getConnection();
            String query = "SELECT first_name, middle_name, last_name, DOJ, email_id FROM EMPLOYEE where email_id=? LIMIT 1";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,email_id);
            ResultSet res = stmt.executeQuery();
            while(res.next()){
                emp = new Employee(res.getString("first_name"),res.getString("middle_name"),
                        res.getString("last_name"),res.getDate("DOJ"),res.getString("email_id")
                        );
            }
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error occured while getting Employee.......");
        }

        return emp;
    }

    @Override
    public Employee updateEmployee(Employee emp) {
        Employee resEmp = null;
        int res;
        try {
            Connection conn = dataSource.getConnection();
            String query = "UPDATE EMPLOYEE set first_name=?, middle_name=?, last_name=? WHERE email_id=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, emp.getFirst_name());
            stmt.setString(2, emp.getMiddle_name());
            stmt.setString(3, emp.getLast_name());
            stmt.setString(4, emp.getEmail_id());
            res = stmt.executeUpdate();
            System.out.println("Number of rows updated : " + res);

            resEmp = getEmployee(emp.getEmail_id());

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error occured while updating Employee.......");
        }

        return resEmp;
    }

    @Override
    public List<Employee> getAllEmployees() {

        List<Employee> listOfEmployee = new ArrayList<>();
        try {
            Connection conn = dataSource.getConnection();
            String query = "SELECT first_name, middle_name, last_name, DOJ, email_id FROM EMPLOYEE";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet res = stmt.executeQuery();
            while(res.next()){
                Employee emp = new Employee(res.getString("first_name"),res.getString("middle_name"),
                        res.getString("last_name"),res.getDate("DOJ"),res.getString("email_id")
                );
                listOfEmployee.add(emp);
            }
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error occured while getting All Employee.......");
        }

        return listOfEmployee;
    }

}
