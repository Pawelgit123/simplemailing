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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class UserWithMailServiceCreateTest {

    @Autowired
    UserWithMailRepository userWithMailRepository;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MockMvc mockMvc;

    private final String requestMappingUrl = "/mail";

    private UserWithMailDTO createUserWithMailDTOForTest() {
        return UserWithMailDTO.builder()
                .email("testdto@gmail.com")
                .build();
    }

    private UserWithMailDTO createUserWithMailDTOForTestNoEmail() {
        return UserWithMailDTO.builder()
                .email("")
                .build();
    }


    @BeforeEach
    void setUp() {
        userWithMailRepository.deleteAll();
    }

    @Test
    void createNewUserWithMail_statusCode200() throws Exception {
        //given
        UserWithMailDTO userWithMailDTO = createUserWithMailDTOForTest();
        String requestBody = objectMapper.writeValueAsString(userWithMailDTO);
        MockHttpServletRequestBuilder post = post(requestMappingUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody);

        //when
        MvcResult result = mockMvc.perform(post).andReturn();

        //then
        MockHttpServletResponse response = result.getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        List<UserWithMail> list = userWithMailRepository.findAll();
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.get(0)).satisfies(userWithMail -> {
            assertThat(userWithMail.getEmail()).isEqualTo("testdto@gmail.com");
        });
    }

    @Test
    void createNewUserWithMail_statusCode400() throws Exception {
        //given
        UserWithMailDTO userWithMailDTO = createUserWithMailDTOForTestNoEmail();
        String requestBody = objectMapper.writeValueAsString(userWithMailDTO);
        MockHttpServletRequestBuilder post = post(requestMappingUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody);

        //when
        MvcResult result = mockMvc.perform(post).andReturn();

        //then
        MockHttpServletResponse response = result.getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
        List<UserWithMail> list = userWithMailRepository.findAll();
        assertThat(list).isEmpty();
        }
}