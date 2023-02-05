package com.exercise.simplemailing.userWithMail;

import com.exercise.simplemailing.exceptions.InternalServerException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserWithMailServiceCreate {

    private final UserWithMailRepository userWithMailRepository;
    private final UserWithMailMapper userWithMailMapper;

    public UserWithMailDTO createNewUserWithMail(UserWithMailDTO userWithMailDTO) {

        if(userWithMailDTO==null){
            throw new InternalServerException("No data to create user with email");
        }

        final UserWithMail userWithMail = userWithMailMapper.mapDTOtoUserWithMail(userWithMailDTO);
        UserWithMail save = userWithMailRepository.save(userWithMail);

        return userWithMailMapper.mapUserWithMailToDTO(save);

    }

}
