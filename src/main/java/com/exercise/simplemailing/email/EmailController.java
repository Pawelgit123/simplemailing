package com.exercise.simplemailing.email;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/send")
public class EmailController {

    private final EmailService emailService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void sendEmailToSpecificAddress(@RequestBody Email email){

        emailService.sendEmail(email);

    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public void sendEmailToAll(@RequestParam String subject, @RequestParam String text) throws IOException {

        emailService.sendEmailToAll(subject, text);

    }
}
