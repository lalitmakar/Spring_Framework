package com.lalit.repository;

import com.lalit.entity.EmployeeEntity;
import com.lalit.models.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional(value = "jpaTransactionManager")
public class EmployeeRepositoryImpl implements  EmployeeRepository{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public int addEmployee(Employee emp) {
        EmployeeEntity entity = convertBeanToEntity(emp);
        System.out.println(entity);
        entityManager.persist(entity);
        System.out.println(emp + " Persisted successfully.......");
        return 1;
    }

    @Override
    @Transactional(value = "jpaTransactionManager",rollbackFor = DummyCheckedExp.class) //for this exp rollback is happenning
    public int addEmloyeeWithCheckedExp(Employee emp) throws DummyCheckedExp {
        EmployeeEntity entity = convertBeanToEntity(emp);
        System.out.println(entity);
        entityManager.persist(entity);
        if(true)
            throw new DummyCheckedExp("Dummy ");
        System.out.println(emp + " Persisted successfully.......");
        return 1;
    }

    @Override
    @Transactional(value = "jpaTransactionManager",readOnly = true) //for this method there will be no error but db doesnt have any entry for the same
    public int addEmloyeeWithReadOnlyMode(Employee emp){
        EmployeeEntity entity = convertBeanToEntity(emp);
        System.out.println(entity);
        entityManager.persist(entity);
        System.out.println(emp + " Persisted successfully.......");
        return 1;
    }

    @Override
    public int addEmloyeeWithUnCheckedExp(Employee emp){ //automatically rollback happens for unchecked exp, but when wrote query for fetching it is not rollbacking, entry is made in db
        EmployeeEntity entity = convertBeanToEntity(emp);
        System.out.println(entity);
        entityManager.persist(entity);
        System.out.println(entity);

        System.out.println("Trying tp fetch from db............");
        Query query = entityManager.createQuery("SELECT e FROM EmployeeEntity e WHERE e.emailId=?1").setParameter(1,emp.getEmailId());
        System.out.println("Query prepared for getting emp is : "+query);
        EmployeeEntity fecthedEntity = (EmployeeEntity) query.getSingleResult();

        System.out.println("Employee fetched from db is  : "+convertEntityToBean(fecthedEntity));


        if(true)
            throw new RuntimeException("This is a dummy runtime exp to check if rollback happends or not");
        System.out.println(emp + " Persisted successfully.......");
        return 1;
    }

    @Override
    public int deleteEmployee(String email_id) {
        Employee emp = getEmployee(email_id);

        if(emp!=null){
            EmployeeEntity entity = convertBeanToEntity(emp);
            if(entityManager.contains(entity)){ // if it is present in persistence context then remove it
                entityManager.remove(entity);
            }
            else{
                EmployeeEntity e = entityManager.merge(entity); // to get the entity back in persistence context !
                entityManager.remove(e);
            }

            System.out.println(emp + " ----- Removed from db ");
            return 1;
        }
        return 0;
    }

    @Override
    public Employee getEmployee(String email_id) {
        Query query = entityManager.createQuery("SELECT e FROM EmployeeEntity e WHERE e.emailId=?1").setParameter(1,email_id);
        System.out.println("Query prepared for getting emp is : "+query);
        EmployeeEntity entity = null;
        try{
            entity = (EmployeeEntity) query.getSingleResult();
        }catch(NoResultException exp){
            System.out.println("Employee with email id :  "+email_id+" doesnt exists in DB...");
            return  null;
        }catch (Exception e){
            System.out.println("Oops something went wrong");
            e.printStackTrace();
            return  null;
        }
        Employee emp =  convertEntityToBean(entity);
        System.out.println("Employee fetched from db is  : "+emp);
        return emp;
    }

    @Override
    public Employee updateEmployee(Employee emp) {

        EmployeeEntity entity = entityManager.merge(convertBeanToEntity(emp));
        return convertEntityToBean(entity);
    }

    @Override
    public List<Employee> getAllEmployees() {

        List<EmployeeEntity> listOfEntity = entityManager.createQuery("SELECT e FROM EmployeeEntity e").getResultList();
        List<Employee> listOfEmployee = new ArrayList<>();
        for(EmployeeEntity entity : listOfEntity){
            listOfEmployee.add(convertEntityToBean(entity));
        }
        System.out.println(listOfEmployee);

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
