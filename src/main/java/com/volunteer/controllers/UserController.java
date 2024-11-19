package com.volunteer.controllers;

import com.volunteer.Enums.role;
import com.volunteer.entities.User;
import com.volunteer.persistance.DAO.UserDAO;

public class UserController {
    UserDAO userDAO;

    public UserController() {
        userDAO = new UserDAO();
    }
    //create user
    public void SingUp(String email, String name, String password, role role){
        User user=new User(email, name, password, role) ;
        this.userDAO.addUser(user);
        
    }

    //log in user returns a modified sinstance of user
    public User logIn(String name,String password){
        User user= this.userDAO.LogIn(name, password);
        //TODODebug looking for what is what will return if there is no user
        return user;
    }
    

}
