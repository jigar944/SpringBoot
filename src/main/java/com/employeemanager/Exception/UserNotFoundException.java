package com.employeemanager.Exception;

public class UserNotFoundException extends RuntimeException{


    public UserNotFoundException(String employee_not_found) {
        super(employee_not_found);
    }
}
