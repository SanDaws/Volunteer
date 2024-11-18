package com.volunteer.entities;

import java.util.Date;

public class Project {

    private int id;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private int createdBy;//user id
        
    private User userFk;

    public Project(String tittle, String description, Date startDate, Date endDate, int createdBy) {
        this.title = tittle;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createdBy = createdBy;
    }
    


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String tittle) {
        this.title = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public String toStringCreated(){
        return "Projects{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", start_date=" + startDate +
                ", end_date=" + endDate +
                ", created_by=" + userFk.getName() +
                '}';
    }

    public String showProject(){
        return "Projects{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", start_date=" + startDate +
                ", end_date=" + endDate +
                '}';
    }


}

// CREATE TABLE projects (
//     id INT PRIMARY KEY AUTO_INCREMENT,
//     title VARCHAR(100) NOT NULL,
//     description TEXT,
//     start_date DATE,
//     end_date DATE,
//     created_by INT,
//     FOREIGN KEY (created_by) REFERENCES users(id) ON DELETE CASCADE
// );