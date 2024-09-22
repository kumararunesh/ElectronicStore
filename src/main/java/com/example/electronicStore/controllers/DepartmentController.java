package com.example.electronicStore.controllers;

import com.example.electronicStore.Services.DepartmentService;
import com.example.electronicStore.entities.Department;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {


    @Autowired
    private DepartmentService departmentService;

    //save operation
    @PostMapping
    public Department saveDepartment(@Valid @RequestBody Department department)
    {
          return departmentService.saveDepartment(department);
    }

    //get a department
    @GetMapping("/{departmentId}")
    public Department getDepartment(@PathVariable("departmentId") int departmentId)
    {
         return departmentService.getDepartment(departmentId);
    }

// get all departments
    @GetMapping
    public List<Department> getAllDepartments()
    {
        return departmentService.getAllDepartments();
    }

    //delete a department
    @DeleteMapping("/{departmentId}")
    public void deleteDepartment(@PathVariable("departmentId") int departmentId)
    {
        departmentService.deleteDepartment(departmentId);
    }

    //update a department
    @PutMapping("/{departmentId}")
    public Department updateDepartment(@RequestBody Department department,
                                       @PathVariable("departmentId") int departmentId)
    {
        return departmentService.updateDepartment(department,departmentId);
    }
}
