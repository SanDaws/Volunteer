package com.volunteer.persistance.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbContext {
    //jdbc:mysql://HOST:PORT/DATABASE_NAME
    private static final String URL="jdbc:mysql://bq7lfmhsgycb8t3mvy0t-mysql.services.clever-cloud.com:3306/bq7lfmhsgycb8t3mvy0t";
    private static final String USER="uwf8za0y2qsgfmlp";
    private static final String PASSWORD="efdgkLH3jfYkePdm5F8w";
    
    private DbContext(){}
    
    public static Connection  getConeection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    
    }

}

