package com.volunteer.entities;

import java.util.Date;

public class Inscription {
    
    private int id;
    private int userId;
    private int projectId;
    private Date date;
    private Project ProjectFK;
    private User UserFK;

    
    public Inscription(Date date, int projectId, int userId) {
        this.date = date;
        this.projectId = projectId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProjectId() {
        return projectId;
    }
    
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    @Override
    public String toString() {
        return "Inscription [id=" + id + ", userId=" + UserFK.getName() + ", projectId=" + ProjectFK.getTitle() + ", date=" + date + "]";
    }
    
    
}

// CREATE TABLE inscriptions (
//     id INT PRIMARY KEY AUTO_INCREMENT,
//     user_id INT,
//     project_id INT,
//     date DATE ,
//     FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
//     FOREIGN KEY (project_id) REFERENCES projects(id) ON DELETE CASCADE,
//     UNIQUE (user_id, project_id) 
// );
