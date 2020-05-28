package com.example.demo.Dao;

import com.example.demo.Model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVoiture extends JpaRepository<Voiture,Long> {
    @Query("select u from  Voiture  u where u.societe.id= :id ")
    List<Voiture> findbySociete(@Param("id") Long id);
}
