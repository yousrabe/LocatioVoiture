package com.example.demo.Controlleur;



import com.example.demo.Dao.IEmployee;
import com.example.demo.Model.Client;
import com.example.demo.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/employee")
public class EmployeRestController {
    @Autowired
    private IEmployee iEmployee;

    @GetMapping("/all")
    public List<Employee> getAll(){
        return iEmployee.findAll();
    }
}
