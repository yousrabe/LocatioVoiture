package com.example.demo.Dao;

import com.example.demo.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReservation extends JpaRepository<Reservation,Long> {

    @Query("select u from  Reservation  u where u.client.id= :id ")
    List<Reservation> findbyReservationClient(@Param("id") Long id);

    @Query("select u from  Reservation  u where u.publication.id= :id ")
    List<Reservation> findbyReservationPublication(@Param("id") Long id);

}
