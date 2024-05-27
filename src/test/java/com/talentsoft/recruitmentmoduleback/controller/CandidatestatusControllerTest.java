package com.talentsoft.recruitmentmoduleback.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.talentsoft.recruitmentmoduleback.model.CandidateStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@WebAppConfiguration
public class CandidatestatusControllerTest {

    private final static String CANDIDATE_STATUS_CONTROLLER_PATH = "/candidatestatus";

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    private MockMvc mockMvc;


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void testGetAllCandidateStatus() throws Exception {
        mockMvc.perform(get(CANDIDATE_STATUS_CONTROLLER_PATH + "/getCandidatestatus"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetCandidatestatusById() throws Exception {

        mockMvc.perform(get(CANDIDATE_STATUS_CONTROLLER_PATH + "/{id}", 1L))
                .andExpect(status().isOk());
    }

    @Test
    void testGetCandidatestatusByIdNotFound() throws Exception {

        mockMvc.perform(get(CANDIDATE_STATUS_CONTROLLER_PATH + "/{id}", 999L))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreateCandidatestatus() throws Exception {
        CandidateStatus candidateStatus = new CandidateStatus();
        candidateStatus.setDescription("Description");
        mockMvc.perform(post(CANDIDATE_STATUS_CONTROLLER_PATH + "/createCandidatestatus")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(candidateStatus)))
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateCandidatestatus() throws Exception {
        CandidateStatus candidateStatus = new CandidateStatus();
        candidateStatus.setDescription("Updated Description");

        mockMvc.perform(put(CANDIDATE_STATUS_CONTROLLER_PATH + "/updateCandidatestatus/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(candidateStatus)))
                .andExpect(status().isOk());
    }
}