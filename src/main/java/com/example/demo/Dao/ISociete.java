package com.example.demo.Dao;

import com.example.demo.Model.Societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISociete extends JpaRepository<Societe,Long> {
}
