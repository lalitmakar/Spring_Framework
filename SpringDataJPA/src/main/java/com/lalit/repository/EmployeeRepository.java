package com.lalit.repository;

import com.lalit.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

    @Query("SELECT e FROM EmployeeEntity e WHERE e.email_id = :email_id")
    EmployeeEntity findEmployeeEntityByEmailId(@Param("email_id") String email_id);

}
