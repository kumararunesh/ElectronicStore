package com.example.electronicStore.Services.impl;

import com.example.electronicStore.Services.DepartmentService;
import com.example.electronicStore.entities.Department;
import com.example.electronicStore.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public Department saveDepartment(Department department)
    {
         return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
          return departmentRepository.findAll();
    }

    @Override
    public Department getDepartment(int departmentId) {

        return departmentRepository.findById(departmentId).get();

    }

    @Override
    public Department updateDepartment(Department department, int departmentId) {

        Department department1 = departmentRepository.findById(departmentId).get();

        department1.setDepartmentAddress(department.getDepartmentAddress());
        department1.setDepartmentName(department.getDepartmentName());
        department1.setDepartmentCode(department1.getDepartmentCode());

        return departmentRepository.save(department1);


    }

    @Override
    public void deleteDepartment(int departmentId) {
            departmentRepository.deleteById(departmentId);
    }

}
