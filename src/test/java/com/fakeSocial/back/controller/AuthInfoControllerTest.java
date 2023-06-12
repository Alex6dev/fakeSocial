package com.fakeSocial.back.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import com.fakeSocial.back.dto.received.NewAuthInfoProfileDto;
import com.fakeSocial.back.service.AuthInfoService;
import com.fakeSocial.back.service.ConfirmCodeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@TestPropertySource(locations = "classpath:test.properties")
public class AuthInfoControllerTest {

    @MockBean
    private AuthInfoService authInfoService;

    @MockBean
    private ConfirmCodeService confirmCodeService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void  givenCorrectBody_WhenPostNewAuthInfoController_ThenSuccess() throws Exception {
        NewAuthInfoProfileDto newAuthInfoProfileDto= new NewAuthInfoProfileDto("name","firstName","email@email.com","2000-01-00");

        Mockito.when(authInfoService.createAuthInfoAndProfile(any(NewAuthInfoProfileDto.class))).thenReturn(true);

        ObjectMapper objectMapper= new ObjectMapper();
        String body=objectMapper
                .valueToTree(newAuthInfoProfileDto)
                .toPrettyString();

        MockHttpServletRequestBuilder query = MockMvcRequestBuilders
                .post("/api/newAuthInfo")
                .contentType("application/json")
                .content(body);

        MvcResult result = mockMvc.perform(query).andReturn();
        String returnedJsonStr = result.getResponse().getContentAsString();

        assertEquals("true",returnedJsonStr);

    }

}
