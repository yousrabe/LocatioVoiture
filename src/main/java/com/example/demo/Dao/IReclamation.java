package com.example.demo.Dao;

import com.example.demo.Model.Reclamation;
import com.example.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReclamation extends JpaRepository<Reclamation,Long> {

    @Query("select u from  Reclamation  u where u.client.id= :id")
    List<Reclamation> findbyClient(@Param("id") Long id);
}
