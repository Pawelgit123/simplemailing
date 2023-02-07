package com.exercise.simplemailing.userWithMail;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

@SpringBootTest
@AutoConfigureMockMvc
class UserWithMailServiceRemoveTest {

    @Autowired
    UserWithMailRepository userWithMailRepository;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MockMvc mockMvc;

    private final String requestMappingUrl = "/mail";

    @BeforeEach
    void setUp() {
        userWithMailRepository.deleteAll();
    }

    private UserWithMail createUserWithMailForTest() {
        return UserWithMail.builder()
                .email("test@gmail.com")
                .build();
    }

    @Test
    void removeUserWithMailByAddress() throws Exception {
        //given
        UserWithMail userWithMail = userWithMailRepository.save(createUserWithMailForTest());
        String param = userWithMail.getEmail();
        MockHttpServletRequestBuilder delete = delete(requestMappingUrl + "/address/{address}", param)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        //when
        MvcResult result = mockMvc.perform(delete).andReturn();

        //then
        MockHttpServletResponse response = result.getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.NO_CONTENT.value());
        List<UserWithMail> list = userWithMailRepository.findAll();
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    void removeUserWithMailById() throws Exception {
        //given
        UserWithMail userWithMail = userWithMailRepository.save(createUserWithMailForTest());
        String param = objectMapper.writeValueAsString(userWithMail.getId());
        MockHttpServletRequestBuilder delete = delete(requestMappingUrl + "/id/{id}", param)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        //when
        MvcResult result = mockMvc.perform(delete).andReturn();

        //then
        MockHttpServletResponse response = result.getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.NO_CONTENT.value());
        List<UserWithMail> list = userWithMailRepository.findAll();
        assertThat(list.size()).isEqualTo(0);
    }
}