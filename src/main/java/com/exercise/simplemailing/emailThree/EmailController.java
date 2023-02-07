package com.exercise.simplemailing.emailThree;

import com.exercise.simplemailing.userWithMail.UserWithMailServiceSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/send")
public class EmailController {

    private final UserWithMailServiceSearch userWithMailServiceSearch;
    private final EmailService emailService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void sentEmailToAll(@RequestBody Email email){

        emailService.sendEmail(email);

//        UserWithMailDTOListed list = userWithMailServiceSearch.getAllUserWithMail();
//        Set<UserWithMailDTO> userWithMailDTOSet = list.getUserWithMailDTOSet();
//
//        for (UserWithMailDTO s : userWithMailDTOSet) {
//            Email email = new Email();
//            email.setAddress(s.getEmail());
//            email.setTitle(title);
//            email.setText(text);
//            emailService.sendEmail(email);
//
//        }
    }
}
