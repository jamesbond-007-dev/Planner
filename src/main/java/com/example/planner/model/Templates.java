package com.example.planner.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "templates")
public class Templates {

    @Column(name ="template_name")
    private String template_name;

    @Column(name = "content")
    private String content;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int template_id;

    
    public String getTemplate_name() {
        return template_name;
    }
    public void setTemplate_name(String template_name) {
        this.template_name = template_name;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public int getTemplate_id() {
        return template_id;
    }
    public void setTemplate_id(int template_id) {
        this.template_id = template_id;
    }


    @Override
    public String toString() {
        return "Users [template_name=" + template_name + ", content=" + content + ", template_id=" + template_id + "]";
    }


    
    

}
