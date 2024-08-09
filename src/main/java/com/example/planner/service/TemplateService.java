package com.example.planner.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.planner.model.Templates;
import com.example.planner.repository.TemplateInterface;



@Service
public class TemplateService implements TemplateServiceInterface {

   
        @Autowired
        TemplateInterface template;


        public Templates saveTemplates(Templates temp){
            return template.save(temp);
        }
}
