package com.exercise.simplemailing.userWithMail;

import com.exercise.simplemailing.exceptions.NotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserWithMailServiceRemove {

    private final UserWithMailRepository userWithMailRepository;

    public void removeUserWithMailByAddress(String address) {
        if (userWithMailRepository.findUserWithMailByEmail(address).isPresent()) {
            userWithMailRepository.deleteById(userWithMailRepository.findUserWithMailByEmail(address).get().getId());
        } else {
            throw new NotFoundException("Not found user with email address: " + address);
        }
    }

    public void removeUserWithMailById(Long id) {
        if (userWithMailRepository.findById(id).isPresent()) {
            userWithMailRepository.deleteById(id);
        } else {
            throw new NotFoundException("Not found user with ID: " + id);
        }
    }

}
