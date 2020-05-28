package com.example.demo.Dao;

import com.example.demo.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IClient extends JpaRepository<Client,Long> {
}
