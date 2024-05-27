package com.talentsoft.recruitmentmoduleback.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Optional;

import com.talentsoft.recruitmentmoduleback.DTO.request.CurriculumRequest;
import com.talentsoft.recruitmentmoduleback.model.Curriculum;
import com.talentsoft.recruitmentmoduleback.service.CurriculumService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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
public class CurriculumControllerTest {

    private final static String CURRICULUM_CONTROLLER_PATH = "/curriculum";

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    private MockMvc mockMvc;

    @Mock
    private CurriculumService curriculumService;


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void testGetCurriculumById() throws Exception {
        mockMvc.perform(get(CURRICULUM_CONTROLLER_PATH + "/{id}", 1L))
                .andExpect(status().isOk());
    }

    @Test
    void testCreateCurriculum() throws Exception {
        CurriculumRequest curriculumRequest = new CurriculumRequest();
        curriculumRequest.setAddress("Address");
        curriculumRequest.setPersonalObjetive("Objective");
        curriculumRequest.setWorkexperience(1);
        curriculumRequest.setEducationalhistory("History");
        curriculumRequest.setLanguage("Language");
        curriculumRequest.setCertification("Certification");
        curriculumRequest.setPersonalreference("Reference");
        curriculumRequest.setUniversity("University");
        curriculumRequest.setCareer("Career");
        mockMvc.perform(post(CURRICULUM_CONTROLLER_PATH + "/createCurriculum")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(curriculumRequest)))
                .andExpect(status().isCreated());
    }

    @Test
    void testUpdateCurriculum() throws Exception {
        Curriculum curriculum = new Curriculum();
        curriculum.setAddress("Updated Address");
        curriculum.setPersonalobjetive("Updated Objective");
        curriculum.setWorkexperience(2);
        curriculum.setEducationalhistory("Updated History");
        curriculum.setLanguage("Updated Language");
        curriculum.setCertification("Updated Certification");
        curriculum.setPersonalreference("Updated Reference");
        curriculum.setUniversity("Updated University");

        when(curriculumService.getById(anyLong())).thenReturn(Optional.of(curriculum));
        when(curriculumService.update(any(Curriculum.class))).thenReturn(curriculum);

        mockMvc.perform(put(CURRICULUM_CONTROLLER_PATH + "/updateCurriculum/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(curriculum)))
                .andExpect(status().isOk());
    }
}