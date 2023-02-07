package com.exercise.simplemailing.emailThree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {

    private String address;
    private String title;
    private String text;

}
