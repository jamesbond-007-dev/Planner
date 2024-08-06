package com.example.planner.model;

import java.time.LocalDateTime;



public class ToDoItems {
    private int id;
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private String priority;
    private boolean status;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDateTime getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ToDoItems [id=" + id + ", title=" + title + ", description=" + description + ", dueDate=" + dueDate
                + ", priority=" + priority + ", status=" + status + "]";
    }

    

    


}
