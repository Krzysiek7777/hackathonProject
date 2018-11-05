package com.example.hackathronaplication.controler;

import com.example.hackathronaplication.model.Team;
import com.example.hackathronaplication.service.HackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class hackControler {

    HackService hackService;
    @Autowired
    public hackControler(HackService hackService) {
        this.hackService = hackService;
    }

    @GetMapping("/hack")//opracowuje
    public String index(Model model, Authentication authentication) {
        return "index";
    }
    @GetMapping("hack/profilT")
    public String profil(Model model, Authentication authentication) {
        model.addAttribute("email", hackService.getEmail(authentication));
        model.addAttribute("isAdmin", hackService.isAdmin(authentication));
        System.out.println("t profil");
        if (hackService.isAdmin(authentication) == true) {

            List<Team> teams = hackService.getAllPosts();
            System.out.println(teams);
            model.addAttribute("isAdmin", hackService.isAdmin(authentication));
            model.addAttribute("email", hackService.getEmail(authentication));
            model.addAttribute("teams", teams);


            return "profilAdmin";
        } else {
       Team team= hackService.DateUserByEmail(authentication);
            System.out.println(team.getTeamname());
            model.addAttribute("team",team);
            return "profilTeam";
        }
    }
    @GetMapping("/hack/registration")
    public String registration(Model model, Authentication authentication) {
        Team team = new Team();
        model.addAttribute("team", team);
        return "rejestracja";
    }

    @PostMapping("/hack/registration")
    public String registration(@ModelAttribute @Valid Team team, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "rejestracja";
        }
        hackService.saveUser(team);
        return "redirect:/hack";
    }

    @GetMapping("/hack/logowanie")
    public String logowanie(Model model, Authentication authentication) {
        System.out.println("logowanie");
        return "loginForm";
    }
}