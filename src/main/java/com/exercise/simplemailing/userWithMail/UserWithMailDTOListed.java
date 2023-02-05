package com.exercise.simplemailing.userWithMail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserWithMailDTOListed {

    private Set<UserWithMailDTO> userWithMailDTOSet;
}
