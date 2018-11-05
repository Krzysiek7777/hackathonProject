package com.example.hackathronaplication.model;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_t;
    @NotBlank(message = "topole moze byc puste")
    @Size(min =3, max=255,message ="pole musi zawierac od {min} do {max}")
    private String teamname;
    @NotBlank(message = "topole moze byc puste")
    @Size(min =3, max=255, message ="pole musi zawierac od {min} do {max}")
    private String player1;
    @Size(min =3, max=255, message ="pole musi zawierac od {min} do {max}")
    private String player2;
    @Size(min =3, max=255, message ="pole musi zawierac od {min} do {max}")
    private String player3;
    @Size(min =3, max=255, message ="pole musi zawierac od {min} do {max}")
    private String player4;
    @Email(message ="niepoprawny adres email" )
    private String email;
     @Size(min=3, max=255, message ="pole musi zawierac od {min} do {max}")
    private String phone;
    @Size(min=3, max=255, message ="pole musi zawierac od {min} do {max}")
    private String password;
    private String permission ;
    private Boolean confirm=false;
    private Boolean active=true;
    public Team() {
    }

    public Team(Boolean active) {
        this.active = true;
    }

    public Team(@NotBlank(message = "topole moze byc puste") @Size(min = 3, max = 255, message = "pole musi zawierac od {min} do {max}") String teamname, @NotBlank(message = "topole moze byc puste") @Size(min = 3, max = 255, message = "pole musi zawierac od {min} do {max}") String player1, @Size(min = 3, max = 255, message = "pole musi zawierac od {min} do {max}") String player2, @Size(min = 3, max = 255, message = "pole musi zawierac od {min} do {max}") String player3, @Size(min = 3, max = 255, message = "pole musi zawierac od {min} do {max}") String player4, @Email(message = "niepoprawny adres email") String email, @Size(min = 3, max = 255, message = "pole musi zawierac od {min} do {max}") String phone, @Size(min = 3, max = 255, message = "pole musi zawierac od {min} do {max}") String password, String permission, Boolean confirm) {
        this.teamname = teamname;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.permission = "ROLE_USER";
        this.confirm = confirm;


    }

    public long getId_t() {
        return id_t;
    }

    public void setId_t(long id_t) {
        this.id_t = id_t;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getPlayer3() {
        return player3;
    }

    public void setPlayer3(String player3) {
        this.player3 = player3;
    }

    public String getPlayer4() {
        return player4;
    }

    public void setPlayer4(String player4) {
        this.player4 = player4;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Boolean getConfirm() {
        return confirm;
    }

    public void setConfirm(Boolean confirm) {
        this.confirm = confirm;
    }
}
