package com.example.planner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.planner.model.Templates;
import com.example.planner.service.TemplateServiceInterface;

@RestController
public class TemplateController {



    @Autowired
    TemplateServiceInterface service;


    @PostMapping("/createTemplates")
    public Templates saveTemplates(   @RequestBody Templates temp){
        return service.saveTemplates(temp);
    }

}
