package com.example.electronicStore.Services;

import com.example.electronicStore.entities.Department;

import java.util.List;

public interface DepartmentService {

//save department
     Department saveDepartment(Department department);

//get Departments list
     List<Department> getAllDepartments();

     //get one Department
    Department getDepartment(int departmentId);

    //update Department
    Department updateDepartment(Department department , int departmentId);

    //Delete Department
    void deleteDepartment(int departmentId);









}
