package com.example.demo.Dao;


import com.example.demo.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IEmployee extends JpaRepository<Employee,Long> {
}
