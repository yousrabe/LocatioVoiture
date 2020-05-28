package com.example.demo.Dao;

import com.example.demo.Model.Publication;
import com.example.demo.Model.Societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPublication extends JpaRepository<Publication,Long> {

    //**********************************
    @Query("select u from  Publication  u where u.voiture.id= :id")
    List<Publication> findbyVoiture(@Param("id") Long id);






    //**********************************



}
