package com.talentsoft.recruitmentmoduleback.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.talentsoft.recruitmentmoduleback.DTO.request.CandidateDTO;
import com.talentsoft.recruitmentmoduleback.exception.CandidateNotFoundException;
import com.talentsoft.recruitmentmoduleback.model.Candidate;
import com.talentsoft.recruitmentmoduleback.service.CandidateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WebAppConfiguration
class CandidateControllerTest {

    private final static String CANDIDATE_CONTROLLER_PATH = "/candidate";

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private CandidateService candidateService;


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void testGetAllByCompany() throws Exception {
        when(candidateService.getAllByCompany(1)).thenReturn(List.of());

        mockMvc.perform(get(CANDIDATE_CONTROLLER_PATH + "/getCandidates/company/{id}", 1))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAllCandidates() throws Exception {
        when(candidateService.getAll()).thenReturn(List.of());

        mockMvc.perform(get(CANDIDATE_CONTROLLER_PATH + "/getAllCandidates"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetCandidateById() throws Exception {
        when(candidateService.getById(1)).thenReturn(Optional.of(new Candidate()));

        mockMvc.perform(get(CANDIDATE_CONTROLLER_PATH + "/{id}", 1))
                .andExpect(status().isOk());
    }

    @Test
    void testGetCandidateByIdNotFound() throws Exception {
        mockMvc.perform(get(CANDIDATE_CONTROLLER_PATH + "/{id}", 999))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreateCandidate() throws Exception {
        Candidate candidate = new Candidate();
        candidate.setName("John");
        candidate.setSurname("Doe");
        candidate.setPhoneNumber("123456789");
        candidate.setOfferId(1);
        candidate.setCvId(1);
        candidate.setCandidateStatusId(1);
        candidate.setCompanyid(1);
        mockMvc.perform(post(CANDIDATE_CONTROLLER_PATH + "/createCandidate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(candidate)))
                .andExpect(status().isCreated());
    }

    @Test
    void testUpdateCandidate() throws Exception {
        CandidateDTO candidateDTO = new CandidateDTO();
        candidateDTO.setPhoneNumber("123456789");
        candidateDTO.setStatus("PENDING");
        mockMvc.perform(put(CANDIDATE_CONTROLLER_PATH + "/updateCandidate/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(candidateDTO)))
                .andExpect(status().isOk());
    }

    @Test
    void testFailedUpdateCandidate() throws Exception {
        mockMvc.perform(put(CANDIDATE_CONTROLLER_PATH + "/updateCandidate/{id}", 90)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new CandidateDTO())))
                .andExpect(status().isNotFound());
    }

    @Test
    void testDeleteCandidate() throws Exception {
        Candidate candidate = new Candidate();
        when(candidateService.softDeleteCandidate(1)).thenReturn(candidate);

        mockMvc.perform(put(CANDIDATE_CONTROLLER_PATH + "/deleteCandidate/{id}", 1))
                .andExpect(status().isOk());
    }

    @Test
    void testFailedDeleteCandidate() throws Exception {
        mockMvc.perform(put(CANDIDATE_CONTROLLER_PATH + "/deleteCandidate/{id}", 77))
                .andExpect(status().isNotFound());
    }
}