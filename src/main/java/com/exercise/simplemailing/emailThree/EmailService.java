package com.exercise.simplemailing.emailThree;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;



    public void sendEmail(Email email) {

            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom("testerpgtester@gmail.com");
            mailMessage.setTo(email.getAddress());
            mailMessage.setText(email.getText());
            mailMessage.setSubject(email.getTitle());

            javaMailSender.send(mailMessage);


    }
}
