package com.example.hackathronaplication.service;

import com.example.hackathronaplication.model.Team;
import com.example.hackathronaplication.repository.HackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HackService {
    String email;
    HackRepository hackRepository;

    @Autowired
    public HackService(HackRepository hackRepository) {
        this.hackRepository = hackRepository;
    }


    public String getEmail(Authentication authentication) {
        String email;
        if (authentication != null) {
            UserDetails principal = (UserDetails) authentication.getPrincipal();
            email = principal.getUsername();
            return email;
        }
        return null;
    }

    public void saveUser(Team team) {

        String password = team.getPassword();
        String password_encoded = new BCryptPasswordEncoder().encode(password);
        team.setPassword(password_encoded);
        hackRepository.save(team);

    }

    public Boolean isAdmin(Authentication authentication) {

        if (authentication != null) {
            UserDetails principal = (UserDetails) authentication.getPrincipal();
            String email = principal.getUsername();
            Team team = hackRepository.findFirstByEmail(email);
            if (team.getPermission().equals("ROLE_ADMIN")) {
                return true;
            } else {
                return false;
            }
        }
        return false;

    }

    public Team DateUserByEmail(Authentication authentication) {
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        String email = principal.getUsername();
        Team team = hackRepository.findFirstByEmail(email);
        System.out.println(team);
        return team;

    }
    public List<Team> getAllPosts(){
        return hackRepository.findAll();
    }
}











