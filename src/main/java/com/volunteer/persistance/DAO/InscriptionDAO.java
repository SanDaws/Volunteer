package com.volunteer.persistance.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.volunteer.entities.Inscription;
import com.volunteer.persistance.db.DbContext;

public class InscriptionDAO {
    private String table= "inscriptions";
    // inscribe to a project
    public void addInscription(Inscription objInscription){
        String query=String.format("INSERT INTO %s (date,user_id,project_id) VALUES (?,?,?);",table);
        try (
            Connection con= DbContext.getConeection();
            PreparedStatement statement = con.prepareStatement(query);
            ){
                statement.setDate(1, java.sql.Date.valueOf(objInscription.getDate()));
                statement.setInt(2,objInscription.getUserId());
                statement.setInt(3,objInscription.getProjectId());
                
                statement.executeLargeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        }
    //volunteers inscriptioNs record
    public List<Inscription> volunteersRecord(int idVolunteer){
        List<Inscription> inscriptionsList= new ArrayList<Inscription>();
        String query=String.format("SELECT inscriptions.date,projects.title,user.name FROM %s JOIN users ON inscriptions.user_id = users.id JOIN projects ON inscriptions.project_id = projects.id WHERE users.id = %d; ",table,idVolunteer);
            try (
            Connection con= DbContext.getConeection();
            Statement statement= con.createStatement();
            ResultSet resul=statement.executeQuery(query);
        ){
            while (resul.next()) {
                LocalDate date= resul.getDate("date").toLocalDate();
                Inscription inscription= new Inscription(
                    resul.getInt("id"),
                    resul.getString("user"),
                    resul.getString("title"),
                    date                    
                );
                inscriptionsList.add(inscription);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  inscriptionsList;
        
    }
    //record of volunnteers inscripted to a project 
    public List<Inscription> InscriptedVolunteers(int idProject ){
        List<Inscription> inscriptionsList= new ArrayList<Inscription>();
        String query=String.format("SELECT inscriptions.date,projects.title,user.name FROM %s JOIN users ON inscriptions.user_id = users.id JOIN projects ON inscriptions.project_id = projects.id WHERE projects.id = %d; ",table,idProject);
            try (
            Connection con= DbContext.getConeection();
            Statement statement= con.createStatement();
            ResultSet resul=statement.executeQuery(query);
        ){
            while (resul.next()) {
                LocalDate date= resul.getDate("date").toLocalDate();
                Inscription inscription= new Inscription(
                    resul.getInt("id"),
                    resul.getString("user"),
                    resul.getString("title"),
                    date                    
                );
                inscriptionsList.add(inscription);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  inscriptionsList;
        
    }
    

}
