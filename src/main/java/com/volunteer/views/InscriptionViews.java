package com.volunteer.views;

import java.util.Scanner;

import com.volunteer.controllers.InscriptionController;



public class InscriptionViews {
    public Scanner sc = new Scanner(System.in);
    private InscriptionController inscriptionController;

    public InscriptionViews(){
        this.inscriptionController=new InscriptionController();
    }
    

}
