package com.exercise.simplemailing.userWithMail;

import com.exercise.simplemailing.exceptions.BadRequestException;
import com.exercise.simplemailing.exceptions.InternalServerException;
import com.exercise.simplemailing.logs.LoggerAll;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Transactional
public class UserWithMailServiceCreate {


    private final LoggerAll logger;
    private final UserWithMailRepository userWithMailRepository;
    private final UserWithMailMapper userWithMailMapper;

    public UserWithMailDTO createNewUserWithMail(UserWithMailDTO userWithMailDTO) throws IOException {

        if (userWithMailDTO == null) {
            logger.makeLog("CREATE-FAIL: no data to create userWithMail");

            throw new InternalServerException("No data to create user with email");
        }

        if (userWithMailDTO.getEmail().isEmpty()) {
            logger.makeLog("CREATE-FAIL: email is empty");
            throw new BadRequestException("Email is empty");
        }
        if (userWithMailDTO.getEmail().isBlank()) {
            logger.makeLog("CREATE-FAIL: email is blank");
            throw new BadRequestException("Email is blank");
        }

        final UserWithMail userWithMail = userWithMailMapper.mapDTOtoUserWithMail(userWithMailDTO);
        UserWithMail save = userWithMailRepository.save(userWithMail);
        logger.makeLog("CREATED UserWithMail: " + userWithMail.getEmail());


        return userWithMailMapper.mapUserWithMailToDTO(save);

    }

}
