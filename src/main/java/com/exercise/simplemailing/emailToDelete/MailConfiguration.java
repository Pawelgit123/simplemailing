package com.exercise.simplemailing.emailToDelete;

import lombok.AllArgsConstructor;

import javax.mail.Session;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@AllArgsConstructor
public class MailConfiguration {

    public MailConfiguration(){
        prepareConfiguration();
    }

    private Properties properties;
    private String userName;
    private String password;

    private void prepareConfiguration(){
        properties = new Properties();

        try(FileReader fileReader = new FileReader("mail.properties")){
            properties.load(fileReader);
        } catch (IOException e){
            e.printStackTrace();
        }
        userName = properties.getProperty("mail.username");
        password = properties.getProperty("mail.password");
    }

    public Session createSession(){
        return Session.getDefaultInstance(properties, new MailAuthenticator(userName,password));
    }
}
