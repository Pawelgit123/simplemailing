package com.exercise.simplemailing.userWithMail;

import com.exercise.simplemailing.exceptions.NotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserWithMailServiceSearch {

    private final UserWithMailRepository userWithMailRepository;

    private final UserWithMailMapper userWithMailMapper;

    public UserWithMailDTO getUserWithMailById(Long id) {

        Optional<UserWithMail> byId = userWithMailRepository.findById(id);

        return userWithMailMapper.mapUserWithMailToDTO(byId
                .orElseThrow(() -> new NotFoundException("Not found UserWithMail with ID: " + id)));

    }

    public UserWithMailDTO getUserWithMailByAddress(String address) {

        Optional<UserWithMail> userWithMailByEmail = userWithMailRepository.findUserWithMailByEmail(address);

        return userWithMailMapper.mapUserWithMailToDTO(userWithMailByEmail
                .orElseThrow(() -> new NotFoundException("Not found UserWithMail with address: " + address)));

    }

    public UserWithMailDTOListed getAllUserWithMail() {

        List<UserWithMail> all = userWithMailRepository.findAll();
        UserWithMailDTOListed userWithMailDTOListed = new UserWithMailDTOListed();

        Set<UserWithMailDTO> collect = all.stream().map(userWithMailMapper::mapUserWithMailToDTO).collect(Collectors.toSet());
        userWithMailDTOListed.setUserWithMailDTOSet(collect);

        return userWithMailDTOListed;

    }

}
