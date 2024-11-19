package com.volunteer.controllers;

import java.time.LocalDate;
import java.util.List;

import com.volunteer.Enums.role;
import com.volunteer.entities.Project;
import com.volunteer.persistance.DAO.ProjectDAO;

public class ProjectController {
    private ProjectDAO projectDAO;

    public ProjectController() {
        projectDAO= new ProjectDAO();
    }
    //add proyect only allowed for PUBLICANTE
    public void addProject(String tittle, String description, LocalDate startDate, LocalDate endDate, int createdBy,role roleUser){
        if (roleUser== role.PUBLICANTE) {
            Project newpProject=new Project(tittle, description, startDate, endDate, createdBy);
        this.projectDAO.addProject(newpProject);
        }
        else{
            System.out.println("Not Creation allowed");
        }

    }
    //show all the projects 
    public List<Project> getAllProjects(){return  this.projectDAO.getAllProjects();}
    

}
