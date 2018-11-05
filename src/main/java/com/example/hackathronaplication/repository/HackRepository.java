package com.example.hackathronaplication.repository;

import com.example.hackathronaplication.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HackRepository extends JpaRepository<Team,Long> {
    Team  findFirstByEmail (String email);

    @Override
    List<Team> findAll();
   Team  findAllByEmail(String email);
}
