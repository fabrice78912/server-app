package com.example.serveur.resource;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
class ServerResourceTest {

    @Autowired
    private MockMvc mockMvc;


    /*@Test
    void getServers() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/server/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Servers retrieved"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("OK"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.statusCode").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.servers").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.servers.length()").value(4));
    }

    @Test
    public void testPingServerWithValidIPAddress() throws Exception {
        String validIpAddress = "192.168.1.1"; // Replace with a valid IP address from your setup
        mockMvc.perform(MockMvcRequestBuilders.get("/server/ping/{ipAddress}", validIpAddress)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("ping success"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("OK"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.server").exists());
    }

    @Test
    public void testPingServerWithInvalidIPAddress() throws Exception {
        String invalidIpAddress = "invalid_ip_address"; // Replace with an invalid IP address
        mockMvc.perform(MockMvcRequestBuilders.get("/server/ping/{ipAddress}", invalidIpAddress)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Ping failed"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("OK"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.server").doesNotExist());
    }*/
}