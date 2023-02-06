package com.exercise.simplemailing.email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

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
