package com.example.demo.Dao;

import com.example.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUser extends JpaRepository<User,Long>{
    @Query("select u from  User  u where u.login= :login and u.mp= :mp")
    User login(@Param("login") String login,@Param("mp") String mp);


}
