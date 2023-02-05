package com.exercise.simplemailing.userWithMail;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserWithMailRepository extends JpaRepository<UserWithMail, Long> {

    Optional<UserWithMail> findUserWithMailByEmail(String email);
}
