package com.volunteer.entities;

public class User {

    private static  enum role{VOLUNTARIO, PUBLICANTE};
    
    private int id;
    private String name;
    private String email;
    private String password;
    private role role;
    
    public User(int id, String name, String email, String password, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = (role=="VOLUNTARIO")? this.role.VOLUNTARIO:this.role.PUBLICANTE;
    }

    public User() {
    }
    
    public User(String email, String name, String password, role role) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRole() {
        return role.name();
    }
    
    public void setRole(role role) {
        this.role = role;
    }
    
    
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email  + ", role=" + role
                + "]";
    }
    
    
}

// CREATE TABLE users (
    //     id INT PRIMARY KEY AUTO_INCREMENT,
    //     name VARCHAR(50) NOT NULL,
    //     email VARCHAR(100) UNIQUE NOT NULL,
    //     password VARCHAR(100) NOT NULL,
    //     role ENUM('VOLUNTARIO', 'PUBLICANTE') NOT NULL
    // );
    