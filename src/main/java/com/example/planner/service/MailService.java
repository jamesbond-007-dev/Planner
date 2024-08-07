package com.example.planner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {


    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(String toEmail,String subject,String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);
        message.setFrom("bloodyrichguy@gmail.com");
        mailSender.send(message);
    }






}
