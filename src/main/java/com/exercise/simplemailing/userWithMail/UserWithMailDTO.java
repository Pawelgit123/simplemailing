package com.exercise.simplemailing.userWithMail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserWithMailDTO {

    private Long id;
    @Email(message = "Email address is inappropriate")
    @NotNull(message = "Email has to be provided")
    private String email;
}
