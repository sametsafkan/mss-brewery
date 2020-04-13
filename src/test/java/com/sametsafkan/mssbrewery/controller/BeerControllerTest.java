package com.sametsafkan.mssbrewery.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sametsafkan.mssbrewery.dto.BeerDto;
import com.sametsafkan.mssbrewery.service.BeerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
@RunWith(SpringRunner.class)
class BeerControllerTest {

    BeerDto beerDto;
    @Autowired
    MockMvc mvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    BeerService beerService;

    @BeforeEach
    public void setUp(){
        beerDto = new BeerDto().builder()
                .id(UUID.randomUUID())
                .name("Tuborg")
                .style("ALE")
                .upc(72527273070L)
                .build();
    }

    @Test
    void findById() throws Exception {
        mvc.perform(get("/api/v1/beer/" + beerDto.getId())
                .accept(APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void save() throws Exception{
        BeerDto savedDto = BeerDto.builder().id(UUID.randomUUID()).name("Corona").build();
        given(beerService.save(any())).willReturn(savedDto);
        beerDto.setId(null);
        String beer = objectMapper.writeValueAsString(beerDto);
        mvc.perform(post("/api/v1/beer/")
                .contentType(APPLICATION_JSON).content(beer)).andExpect(status().isCreated());
    }

    @Test
    void update() throws Exception{
        beerDto.setId(null);
        String beer = objectMapper.writeValueAsString(beerDto);
        mvc.perform(put("/api/v1/beer/" + UUID.randomUUID())
                .contentType(APPLICATION_JSON).content(beer)).andExpect(status().isNoContent());
    }
}