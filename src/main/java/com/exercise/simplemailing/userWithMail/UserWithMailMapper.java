package com.exercise.simplemailing.userWithMail;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserWithMailMapper {

    public UserWithMailDTO mapUserWithMailToDTO(UserWithMail userWithMail) {
        return UserWithMailDTO.builder()
                .email(userWithMail.getEmail())
                .id(userWithMail.getId())
                .build();
    }

    public UserWithMail mapDTOtoUserWithMail(UserWithMailDTO userWithMailDTO){
        return UserWithMail.builder()
                .email(userWithMailDTO.getEmail())
                .build();
    }
}
