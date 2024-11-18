package com.volunteer.persistance.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.volunteer.entities.Project;
import com.volunteer.persistance.db.DbContext;

public class ProjectDAO {
    private String table= "projects";
    
    //Create a project
    public void addProject(Project objProject){
        String query=String.format("INTSERT INTO %s (title,description,start_date,end_date,created_by) VALUES (?,?,?,?,?)",table);
        try (
            Connection con= DbContext.getConeection();
            PreparedStatement statement = con.prepareStatement(query);
            )
            {
                statement.setString(1, objProject.getTitle());
                statement.setString(2, objProject.getDescription());
                statement.setDate(3,java.sql.Date.valueOf(objProject.getStartDate()));
                statement.setDate(4,java.sql.Date.valueOf(objProject.getEndDate()));
                statement.setString(5, objProject.getTitle());
                statement.executeLargeUpdate();

                
            } catch (Exception e) {
                e.printStackTrace();
            }
        

    }
    //TODOlist all projects avaliables
    public List<Project> getAllProjects(){
        List<Project> projects= new ArrayList<Project>();
        //TODO definition
        
        return  projects;

    }

}
