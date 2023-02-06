package com.exercise.simplemailing.userWithMail;

import com.exercise.simplemailing.exceptions.BadRequestException;
import com.exercise.simplemailing.exceptions.InternalServerException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
@Transactional
public class UserWithMailServiceCreate {

//    private final Logger logger;

    private final UserWithMailRepository userWithMailRepository;
    private final UserWithMailMapper userWithMailMapper;

    public UserWithMailDTO createNewUserWithMail(UserWithMailDTO userWithMailDTO) {

        if(userWithMailDTO==null){
            throw new InternalServerException("No data to create user with email");
        }

        if(userWithMailDTO.getEmail().isEmpty()){
            throw new BadRequestException("Email is empty");
        }
        if(userWithMailDTO.getEmail().isBlank()){
            throw new BadRequestException("Email is blank");
        }

        final UserWithMail userWithMail = userWithMailMapper.mapDTOtoUserWithMail(userWithMailDTO);
        UserWithMail save = userWithMailRepository.save(userWithMail);
//        logger.log(Level.INFO,"new UserWithMail created");


        return userWithMailMapper.mapUserWithMailToDTO(save);

    }

}
