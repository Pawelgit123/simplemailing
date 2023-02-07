package com.exercise.simplemailing.emailToDelete;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
@Transactional
@RequiredArgsConstructor
public class MailServiceSendEmail {

    public void sentEmail(Email email){
        MailConfiguration mailConfiguration = new MailConfiguration();
        Session session = mailConfiguration.createSession();
        try{
            MimeMessage message = new MimeMessage(session);
            message.setText(email.getContent());
            message.setSubject(email.getSubject());
            message.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(email.getAddress())));
            Transport.send(message);
        } catch (MessagingException e){
            e.printStackTrace();
        }
    }

}
