package com.volunteer.persistance.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.volunteer.entities.Project;
import com.volunteer.persistance.db.DbContext;

public class ProjectDAO {
    private String table= "projects";
    private String userTable="users";

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
    
    //list all projects avaliables
    public List<Project> getAllProjects(){
        List<Project> projects= new ArrayList<Project>();
        String query=String.format("SELECT projects.title,projects.description,projects.start_date,projects.end_date,users.name FROM %s JOIN users ON projects.created_by = users.id;  ;",table);
        try (
            Connection con= DbContext.getConeection();
            Statement statement= con.createStatement();
            ResultSet resul=statement.executeQuery(query);
        ){
            while (resul.next()) {
                LocalDate Startdate= resul.getDate("start_date").toLocalDate();
                LocalDate Enddate= resul.getDate("end_date").toLocalDate();
                Project project= new Project(
                    resul.getInt("id"),
                    resul.getString("title"),
                    resul.getString("description"),
                    Startdate,
                    Enddate,
                    resul.getString("name")
                );
                projects.add(project);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return  projects;

    }

}
