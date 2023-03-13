package com.exercise.simplemailing.userWithMail;

import com.exercise.simplemailing.exceptions.NotFoundException;
import com.exercise.simplemailing.logs.LoggerAll;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Transactional
public class UserWithMailServiceRemove {

    private final LoggerAll logger;
    private final UserWithMailRepository userWithMailRepository;

    public void removeUserWithMailByAddress(String address) throws IOException {
        if (userWithMailRepository.findUserWithMailByEmail(address).isPresent()) {
            Long id = userWithMailRepository.findUserWithMailByEmail(address).get().getId();
            logger.makeLog("REMOVED userWithMail: " + address);
            userWithMailRepository.deleteById(id);
        } else {
            throw new NotFoundException("Not found user with email address: " + address);
        }
    }

    public void removeUserWithMailById(Long id) throws IOException {
        if (userWithMailRepository.findById(id).isPresent()) {
            logger.makeLog("REMOVED userWithMail: " + id);
            userWithMailRepository.deleteById(id);
        } else {
            throw new NotFoundException("Not found user with ID: " + id);
        }
    }

}
