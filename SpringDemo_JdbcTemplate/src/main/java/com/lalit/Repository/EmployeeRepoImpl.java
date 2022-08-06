package com.lalit.Repository;

import com.lalit.Models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeRepoImpl implements  EmployeeRepo{

    @Autowired
    JdbcTemplate jdbcTemplate;
    // to fetch data use query(), to use DML statments use execute(query,preparedstmtCallback) or update()

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    //usage is in getemployee() Method

    @Override
    public int addEmployee(Employee emp) {

        int res = -1;
        String query = "INSERT INTO EMPLOYEE VALUES (DEFAULT,?,?,?,?,?)";
        res = jdbcTemplate.execute(query, new PreparedStatementCallback<Integer>() {
            @Override
            public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setString(1,emp.getFirst_name());
                ps.setString(2,emp.getMiddle_name());
                ps.setString(3,emp.getLast_name());
                ps.setDate(4,emp.getDOJ()==null ? new Date(new java.util.Date().getTime()) : new Date(emp.getDOJ().getTime()));
                ps.setString(5,emp.getEmail_id());
                return ps.executeUpdate();
            }
        });
        System.out.println("Number of rows updated : "+res);
        return res;
    }

    @Override
    public int deleteEmployee(String email_id) {
        int res = -1;
        String query = "DELETE FROM EMPLOYEE where email_id=?";
        res = jdbcTemplate.execute(query, new PreparedStatementCallback<Integer>() {
            @Override
            public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setString(1,email_id);
                return ps.executeUpdate();
            }
        });

        System.out.println("Number of rows updated : "+res);
        return res;
    }

    @Override
    public Employee getEmployee(String email_id) {
        Employee resEmp = null;
        String query = "SELECT first_name, middle_name, last_name, DOJ, email_id FROM EMPLOYEE where email_id=:email LIMIT 1";

        Map<String,Object> map = new HashMap<>();
        map.put("email",email_id);

        resEmp = namedParameterJdbcTemplate.execute(query, map, new PreparedStatementCallback<Employee>() {
            @Override
            public Employee doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                System.out.println("Inside named param execute");
                System.out.println(ps); // final query to execute
                ResultSet res = ps.executeQuery();
                Employee emp = null;
                while(res.next()){
                    emp = new Employee(res.getString("first_name"),res.getString("middle_name"),
                            res.getString("last_name"),res.getDate("DOJ"),res.getString("email_id")
                    );
                }
                return emp;
            }
        });


//        resEmp = jdbcTemplate.query(query, new ResultSetExtractor<Employee>() {
//            @Override
//            public Employee extractData(ResultSet res) throws SQLException, DataAccessException {
//                Employee emp = null;
//                while(res.next()){
//                    emp = new Employee(res.getString("first_name"),res.getString("middle_name"),
//                            res.getString("last_name"),res.getDate("DOJ"),res.getString("email_id")
//                    );
//                }
//                return emp;
//            }
//        });

        return resEmp;
    }

    @Override
    public Employee updateEmployee(Employee emp) {
        Employee resEmp = null;
        int res;
        String query = "UPDATE EMPLOYEE set first_name=?, middle_name=?, last_name=? WHERE email_id=?";
        res = jdbcTemplate.execute(query, new PreparedStatementCallback<Integer>() {
            @Override
            public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setString(1, emp.getFirst_name());
                ps.setString(2, emp.getMiddle_name());
                ps.setString(3, emp.getLast_name());
                ps.setString(4, emp.getEmail_id());
                return ps.executeUpdate();
            }
        });

        System.out.println("Number of rows updated : " + res);
        resEmp = getEmployee(emp.getEmail_id());
        return resEmp;
    }

    @Override
    public List<Employee> getAllEmployees() {

        List<Employee> listOfEmployee = null;
        String query = "SELECT first_name, middle_name, last_name, DOJ, email_id FROM EMPLOYEE";

        listOfEmployee = jdbcTemplate.query(query, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet res, int rowNum) throws SQLException {
                Employee emp = new Employee(res.getString("first_name"),res.getString("middle_name"),
                        res.getString("last_name"),res.getDate("DOJ"),res.getString("email_id")
                );
                return emp;
            }
        });

        System.out.println("Using Rowmapper");

        return listOfEmployee;
    }

}
