package com.volunteer.views.Auth;

import java.util.Scanner;

import com.volunteer.controllers.UserController;
import com.volunteer.entities.User;

public class LogginView {
    public Scanner sc = new Scanner(System.in);
    private UserController userController;

    public LogginView(){
        this.userController=new UserController();
    }
    public User log(){
        User user = new User();
        int tryes= 3;
        while (tryes!=0) {
            System.out.print("correo: ");
            String email=this.sc.nextLine();

            System.out.print("contraseña: ");
            String password=this.sc.nextLine();
            if (password.isEmpty() || password.isBlank() ||email.isEmpty() || email.isBlank()) {
                System.out.println("no campos vacios");
                tryes--;
                continue;
            }
            //now we llok for user
            user=this.userController.logIn(email, password);
            if (user.IsEmpty()) {
                System.out.println("usuario o contraseña incorrecto");
                tryes--;
                continue;    
            }
            System.out.println("Access Granted");
           break;

            
        }
        return user;
    }


}
