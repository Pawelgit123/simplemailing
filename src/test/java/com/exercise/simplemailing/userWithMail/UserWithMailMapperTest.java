package com.exercise.simplemailing.userWithMail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class UserWithMailMapperTest {

    @Mock
    private UserWithMailRepository userWithMailRepository;


    @BeforeEach
    void setUp() {
        userWithMailRepository.deleteAll();
    }

    private UserWithMailDTO createUserWithMailDTOForTest() {
        return UserWithMailDTO
                .builder()
                .email("testdto@gmail.com")
                .build();
    }
    private UserWithMail createUserWithMailForTest() {
        return UserWithMail
                .builder()
                .email("testuser@gmail.com")
                .build();
    }


    @Test
    void mapUserWithMailToDTO() {
        //given
        UserWithMailMapper userWithMailMapper = new UserWithMailMapper();

        //when
        UserWithMailDTO userWithMailDTO = userWithMailMapper.mapUserWithMailToDTO(createUserWithMailForTest());

        //then
        assertThat(userWithMailDTO).isExactlyInstanceOf(UserWithMailDTO.class);
        assertThat(userWithMailDTO.getEmail()).isEqualTo(createUserWithMailForTest().getEmail());
    }

    @Test
    void mapDTOtoUserWithMail() {
        //given
        UserWithMailMapper userWithMailMapper = new UserWithMailMapper();

        //when
        UserWithMail userWithMail = userWithMailMapper.mapDTOtoUserWithMail(createUserWithMailDTOForTest());

        //then
        assertThat(userWithMail).isExactlyInstanceOf(UserWithMail.class);
        assertThat(userWithMail.getEmail()).isEqualTo(createUserWithMailDTOForTest().getEmail());
    }
}