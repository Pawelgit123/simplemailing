package com.exercise.simplemailing.email;

import com.exercise.simplemailing.userWithMail.UserWithMailDTO;
import com.exercise.simplemailing.userWithMail.UserWithMailDTOListed;
import com.exercise.simplemailing.userWithMail.UserWithMailServiceSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/send")
public class MailController {

    private final UserWithMailServiceSearch userWithMailServiceSearch;
    private final MailServiceSendEmail mailServiceSendEmail;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void sentEmailToAll(String title, String content){

        //Todo check this

        UserWithMailDTOListed list = userWithMailServiceSearch.getAllUserWithMail();
        Set<UserWithMailDTO> userWithMailDTOSet = list.getUserWithMailDTOSet();

        for (UserWithMailDTO s : userWithMailDTOSet) {
            Email email = new Email(s.getEmail(),title, content);
            mailServiceSendEmail.sentEmail(email);
        }
    }

}
