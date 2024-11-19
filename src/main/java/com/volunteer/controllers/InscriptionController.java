package com.volunteer.controllers;

import com.volunteer.persistance.DAO.InscriptionDAO;



public class InscriptionController {
    
    private InscriptionDAO inscriptionDAO;
    public InscriptionController(){
        this.inscriptionDAO=new InscriptionDAO();
    }
    //TODO only volunteers are allowed to generate isncriptions
    //TODO see all the inscriptions from a specific volunteer
    //TODO see all the volunteers for an specific project

}
