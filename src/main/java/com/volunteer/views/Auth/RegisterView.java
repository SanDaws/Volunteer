package com.volunteer.views.Auth;
import java.util.Scanner;

import com.volunteer.Enums.role;
import com.volunteer.controllers.UserController;
import com.volunteer.entities.User;

public class RegisterView {
    public Scanner sc = new Scanner(System.in);
    private UserController userController;

    public RegisterView(){
        this.userController=new UserController();
    }
    
    public User RegistUser(){
        System.out.println("todos campos obligatorios");
        System.out.println("nombre");
        String name=this.sc.nextLine();

        System.out.println("Email");
        String email=this.sc.nextLine();


        System.out.println("contraseña");
        String password=this.sc.nextLine();

        role rol= switchRole();


        User user = new User(email,name,password,rol);


        return  user;
    }
    public role switchRole(){

        System.out.println("""
                seleccione rol:
                1: voluntario
                2: publicante
                """);
                int opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        return role.VOLUNTARIO;
                        
                    case 2:
                        return role.PUBLICANTE;

                    default:
                        return role.VOLUNTARIO;
                }
    }

}
