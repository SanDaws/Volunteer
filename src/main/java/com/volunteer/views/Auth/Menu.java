package com.volunteer.views.Auth;

import java.util.Scanner;

import com.volunteer.entities.User;

public class Menu {
    public Scanner sc = new Scanner(System.in);
    public User user;

    //one option for register one for  log in
    public User Menu(){
        int opcion;

    
        do{
            System.out.println("""
            === Bienvenido===
            1. Registrarse
            2. iniciar sesion
            5. Salir
            Seleccione una opción: """);
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea
            this.option(opcion);
            
        } while (opcion != 5);
    
        sc.close();
        return  user;
        }
        public void option(int opcion){
            switch (opcion) {
                case 1:
                LogginView lv=new LogginView();
                user=lv.log();
                if (user.IsEmpty()) {
                    System.out.println("imposible conectar");
                }
            break;
    
                case 2:
                RegisterView rv= new RegisterView();
                user=rv.RegistUser();
                
                break;

            case 5:
                System.out.println("Saliendo del programa...");
                break;

            default:
                System.out.println("Opción no válida. Intente nuevamente.");
        }
        }

}
