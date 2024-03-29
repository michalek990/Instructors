package com.example.instructors.City;

import com.example.instructors.City.dto.CityRequest;
import com.example.instructors.City.dto.CityResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class CityControllerTest {

    @Mock
    private CityService cityService;

    @InjectMocks
    private CityController cityController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(cityController).build();
    }

    @Test
    void createCity_shouldReturnCreated() throws Exception {
        CityRequest cityRequest = CityRequest.builder()
                .name("Test City")
                .countryName("Test Country")
                .build();
        CityResponse cityResponse = CityResponse.builder()
                .name("Test City")
                .build();

        when(cityService.createCity(any(CityRequest.class))).thenReturn(cityResponse);

        mockMvc.perform(post("/api/v1/cities")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(cityRequest)))
                .andExpect(status().isCreated());
    }
}
