package com.employeemanager.Service;

import com.employeemanager.Exception.UserNotFoundException;
import com.employeemanager.Repository.EmployeeRepo;
import com.employeemanager.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee e){
        e.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(e);
    }

    public List<Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }

    public Employee update(Employee e){
        return employeeRepo.save(e);
    }

    public Employee findEmployeeById(long id){
        return employeeRepo.findEmployeeById(id).orElseThrow(()-> new UserNotFoundException("Employee not found"));
    }

    public void deleteEmployee(long id){
        employeeRepo.deleteEmployeeById(id);
    }
}
