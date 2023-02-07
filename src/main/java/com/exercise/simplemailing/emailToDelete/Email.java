package com.exercise.simplemailing.emailToDelete;

import lombok.Data;

@Data
public class Email {

    private final String address;
    private final String subject;
    private final String content;
    private final Boolean isSent;

    public Email(String address, String subject, String content){
        this.address = address;
        this.subject = subject;
        this.content = content;
        isSent = false;
    }
}
