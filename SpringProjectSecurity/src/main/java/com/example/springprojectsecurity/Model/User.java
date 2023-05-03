/*
package com.example.springprojectsecurity.Model;



import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String username;
    private int active;
    @Column(nullable = false)
    private String password;
    private String roles="";
    private String permission="";

    public User(String username, String password, String roles, String permission) {

        this.username = username;
        this.password = password;
        this.roles = roles;
        this.permission = permission;
        this.active = 1;
    }


    public User() {

    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getActive() {
        return active;
    }

    public String getPassword() {
        return password;
    }

    public String getRoles() {
        return roles;
    }

    public String getPermission() {
        return permission;
    }

    public List<String> getRoleList(){
        if(this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionList(){
        if(this.permission.length() > 0){
            return List.of((this.permission.split(",")));
        }
        return new ArrayList<>();
    }
}
*/
