package com.exercise.simplemailing.userWithMail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserWithMailTest {

    UserWithMail userWithMail = new UserWithMail();

    @BeforeEach
    void setUp() {
        userWithMail.setEmail("test@gmail.com");
    }

    @Test
    void getEmailWithProperSymbol() {
        assertTrue(userWithMail.getEmail().contains("@"));

    }
    @Test
    void getEmailIsNotBlank() {
        assertFalse(userWithMail.getEmail().isBlank());

    }

    @Test
    void getEmailIsNotEmpty() {
        assertFalse(userWithMail.getEmail().isEmpty());

    }


}