package com.talentsoft.recruitmentmoduleback.controller;

import com.talentsoft.recruitmentmoduleback.DTO.request.OfferUpdateRequest;
import com.talentsoft.recruitmentmoduleback.DTO.request.OfferUpdateStatusRequest;
import com.talentsoft.recruitmentmoduleback.model.Offer;
import com.talentsoft.recruitmentmoduleback.service.OfferService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.Optional;
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
public class OfferControllerTest {

    private final static String OFFER_CONTROLLER_PATH = "/offer";

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    private MockMvc mockMvc;

    @Mock
    private OfferService offerService;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void testGetAllOffers() throws Exception {
        mockMvc.perform(get(OFFER_CONTROLLER_PATH + "/getAll"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAllOffersByCompany() throws Exception {
        mockMvc.perform(get(OFFER_CONTROLLER_PATH + "/getOffers/{id}", 1L))
                .andExpect(status().isOk());
    }

    @Test
    void testGetOfferById() throws Exception {
        mockMvc.perform(get(OFFER_CONTROLLER_PATH + "/{id}", 1L))
                .andExpect(status().isOk());
    }

    @Test
    void testGetOfferByIdNotFound() throws Exception {
        mockMvc.perform(get(OFFER_CONTROLLER_PATH + "/{id}", 999L))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreateOffer() throws Exception {
        Offer offer = new Offer();
        offer.setTittleoffer("tittleoffer");
        offer.setDescription("description");
        offer.setExperience(1);
        offer.setPublishdate("publishdate");
        offer.setRequeriments("requeriments");
        offer.setStatus("status");
        offer.setCompanyid(1);

        mockMvc.perform(post(OFFER_CONTROLLER_PATH + "/createOffer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(offer)))
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateOffer() throws Exception {
        OfferUpdateRequest offerUpdateRequest = new OfferUpdateRequest();
        offerUpdateRequest.setTittleOffer("tittleOffer");
        offerUpdateRequest.setDescription("description");
        offerUpdateRequest.setRequirements("requirements");
        offerUpdateRequest.setStatus("status");

        mockMvc.perform(put(OFFER_CONTROLLER_PATH + "/updateOffer/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(offerUpdateRequest)))
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateOfferStatus() throws Exception {
        OfferUpdateStatusRequest statusRequest = new OfferUpdateStatusRequest();
        Offer offer = new Offer();
        mockMvc.perform(put(OFFER_CONTROLLER_PATH + "/updateStatus/{id}", 2L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(statusRequest)))
                .andExpect(status().isOk());
    }
    @Test
    void testFailUpdateOfferStatus() throws Exception {
        mockMvc.perform(put(OFFER_CONTROLLER_PATH + "/updateStatus/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString("status")))
                .andExpect(status().isNotFound());
    }

    @Test
    void testDeleteOffer() throws Exception {

        mockMvc.perform(delete(OFFER_CONTROLLER_PATH + "/deleteOffer/{id}", 2L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString("Eliminado")))
                .andExpect(status().isOk());
    }
}