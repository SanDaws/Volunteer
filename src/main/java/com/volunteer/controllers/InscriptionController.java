package com.volunteer.controllers;

import java.util.List;

import com.volunteer.Enums.role;
import com.volunteer.entities.Inscription;
import com.volunteer.persistance.DAO.InscriptionDAO;



public class InscriptionController {
    
    private InscriptionDAO inscriptionDAO;
    public InscriptionController(){
        this.inscriptionDAO=new InscriptionDAO();
    }
    //only volunteers are allowed to generate isncriptions
     public void addInscription(int projectId, int userId,role roleUser){
        if (roleUser== role.VOLUNTARIO) {
            Inscription newInscription=new Inscription(projectId, userId);
        this.inscriptionDAO.addInscription(newInscription);
        }
        else{
            System.out.println("Not Registracion allowed");
        }

    }
    // see all the inscriptions from a specific volunteer
    public List<Inscription> volunteersRecord(int idVolunteer){
        //TODODebug for what to do if empty List
        return  this.inscriptionDAO.volunteersRecord(idVolunteer);
    }

    // see all the volunteers for an specific project
    public List<Inscription> InscriptedVolunteers(int idProject ){
        //TODODebug for what to do if empty List
        return  this.inscriptionDAO.InscriptedVolunteers(idProject);
    }


}
