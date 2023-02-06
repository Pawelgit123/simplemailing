package com.exercise.simplemailing.userWithMail;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class UserWithMailServiceSearchTest {

    @Autowired
    private UserWithMailRepository userWithMailRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    private final String requestMappingUrl = "/mail";

    private UserWithMail createUserWithMailForTestOne() {
        return UserWithMail.builder()
                .email("testone@gmail.com")
                .build();
    }

    private UserWithMail createUserWithMailForTestTwo() {
        return UserWithMail.builder()
                .email("testtwo@gmail.com")
                .build();
    }

    private UserWithMail createUserWithMailForTestThree() {
        return UserWithMail.builder()
                .email("testthree@gmail.com")
                .build();
    }

    @BeforeEach
    void setUp() {
        userWithMailRepository.deleteAll();
    }

    @Test
    void getUserWithMailById() throws Exception {
        //given
        UserWithMail save = userWithMailRepository.save(createUserWithMailForTestOne());
        userWithMailRepository.save(createUserWithMailForTestTwo());
        userWithMailRepository.save(createUserWithMailForTestThree());
        Long id = save.getId();
        MockHttpServletRequestBuilder request = get(requestMappingUrl+"/{id}", id);

        //when
        MockHttpServletResponse response = mockMvc.perform(request).andReturn().getResponse();

        //then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        UserWithMailDTO userWithMailDTO = objectMapper.readValue(response.getContentAsString(StandardCharsets.UTF_8), new TypeReference<>() {
        });
        assertThat(userWithMailDTO.getId()).isEqualTo(id);

    }

    @Test
    void getUserWithMailByAddress() throws Exception {
        //given
        UserWithMail save = userWithMailRepository.save(createUserWithMailForTestOne());
        userWithMailRepository.save(createUserWithMailForTestTwo());
        userWithMailRepository.save(createUserWithMailForTestThree());
        String email = save.getEmail();
        MockHttpServletRequestBuilder request = get(requestMappingUrl+"/{address}", email);

        //when
        MockHttpServletResponse response = mockMvc.perform(request).andReturn().getResponse();

        //then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        UserWithMailDTO userWithMailDTO = objectMapper.readValue(response.getContentAsString(StandardCharsets.UTF_8), new TypeReference<>() {
        });
        assertThat(userWithMailDTO.getEmail()).isEqualTo(save.getEmail());
    }

    @Test
    void getAllUserWithMail() throws Exception {
        //given
        userWithMailRepository.save(createUserWithMailForTestOne());
        userWithMailRepository.save(createUserWithMailForTestTwo());
        userWithMailRepository.save(createUserWithMailForTestThree());
        MockHttpServletRequestBuilder request = get(requestMappingUrl);

        //when
        MockHttpServletResponse response = mockMvc.perform(request).andReturn().getResponse();

        //then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        UserWithMailDTOListed list = objectMapper.readValue(response.getContentAsString(StandardCharsets.UTF_8), new TypeReference<>() {
        });
        assertThat(list.getUserWithMailDTOSet().size()).isEqualTo(3);
    }
}