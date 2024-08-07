package com.example.planner.controller;

import com.example.planner.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @Autowired
    private MailService mailService;

    @GetMapping("/sendEmail")
    public String eMail(@RequestParam String toEmail, @RequestParam String subject , String body){
        mailService.sendSimpleEmail(toEmail,subject,body);
        return "Email Sent Successfully";
    }

}
