package com.exercise.simplemailing.email;


import com.exercise.simplemailing.userWithMail.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    private final UserWithMailServiceSearch userWithMailServiceSearch;


    public void sendEmail(Email email) {

            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom("testerpgtester@gmail.com");
            mailMessage.setTo(email.getAddress());
            mailMessage.setText(email.getText());
            mailMessage.setSubject(email.getTitle());

            javaMailSender.send(mailMessage);
    }

    public void sendEmailToAll(EmailToAll email) throws IOException {

        UserWithMailDTOListed allUserWithMail = userWithMailServiceSearch.getAllUserWithMail();
        Set<UserWithMailDTO> userWithMailDTOSet = allUserWithMail.getUserWithMailDTOSet();

        for (UserWithMailDTO user: userWithMailDTOSet) {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("testerpgtester@gmail.com");
            mailMessage.setTo(user.getEmail());
            mailMessage.setText(email.getText());
            mailMessage.setSubject(email.getTitle());

            javaMailSender.send(mailMessage);
        }
    }
}
