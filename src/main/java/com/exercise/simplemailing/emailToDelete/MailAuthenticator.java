package com.exercise.simplemailing.emailToDelete;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


@AllArgsConstructor
@NoArgsConstructor
public class MailAuthenticator extends Authenticator {

    private String userName;
    private String password;

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(userName, password);
    }
}
