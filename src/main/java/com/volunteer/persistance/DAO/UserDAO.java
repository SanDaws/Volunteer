package com.volunteer.persistance.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.volunteer.entities.User;
import com.volunteer.persistance.db.DbContext;

public class UserDAO {
    private String table= "users";

    public void addUser(User objUser){
        String SQLsentence=String.format("INSERT INTO %s (name,email,password,role) VALUES (?,?,?,?);",table);
        try (
            Connection con= DbContext.getConeection();
            PreparedStatement statement = con.prepareStatement(SQLsentence);
        ) {
            statement.setString(1, objUser.getName());
            statement.setString(2, objUser.getEmail());
            statement.setString(3, objUser.getPassword());
            statement.setString(4, objUser.getRole());
            
            statement.executeLargeUpdate();

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User GetUserByid(int id){
        User user=new User();
        String GetUser=String.format("SELECT * FROM %s WHERE id = %d;",table,id);
        try (
            Connection con= DbContext.getConeection();
            Statement statement= con.createStatement();
            ResultSet resul=statement.executeQuery(GetUser);
        ){
            while (resul.next()) {
                user=new User(
                    resul.getInt("id"),
                    resul.getString("name"),
                    resul.getString("email"),
                    resul.getString("password"),
                    resul.getString("role")

                );
                
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return user;

        


    }

    public void editUser(int id,User objUpdatedUser){
        String alterUserQuery=  String.format("UPDATE %s SET name=?,email=?,password=?,role=? WHERE id=%d",table,id);
        try (
            Connection con= DbContext.getConeection();
            PreparedStatement statement = con.prepareStatement(alterUserQuery);
        ){
            statement.setString(1, objUpdatedUser.getName());
            statement.setString(2, objUpdatedUser.getEmail());
            statement.setString(3, objUpdatedUser.getPassword());
            statement.setString(4, objUpdatedUser.getRole());

            statement.executeLargeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
