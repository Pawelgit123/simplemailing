package com.exercise.simplemailing;


import com.exercise.simplemailing.logs.LoggerAll;
import com.exercise.simplemailing.userWithMail.UserWithMail;
import com.exercise.simplemailing.userWithMail.UserWithMailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;


@RequiredArgsConstructor
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class, SecurityFilterAutoConfiguration.class})
public class SimpleMailingApplication implements CommandLineRunner {

    private final UserWithMailRepository userWithMailRepository;

    public static void main(String[] args) {
        SpringApplication.run(SimpleMailingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userWithMailRepository.deleteAll();
        UserWithMail userWithMail = new UserWithMail();
        userWithMail.setEmail("testerpgtester@gmail.com");
        userWithMailRepository.save(userWithMail);

        UserWithMail userWithMailTwo = new UserWithMail();
        userWithMailTwo.setEmail("testerpgtester2@gmail.com");
        userWithMailRepository.save(userWithMailTwo);

    }
}
