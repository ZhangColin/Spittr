package com.cartisan.spittr.spitter.controller;

import com.cartisan.spittr.spitter.domain.Spitter;
import com.cartisan.spittr.spitter.repository.SpitterRepository;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by Administrator on 2016/10/10.
 */
public class SpitterControllerTest {
    @Test
    public void showRegistrationForm() throws Exception {
        SpitterController controller = new SpitterController(mock(SpitterRepository.class));
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/spitters/register"))
                .andExpect(view().name("spitters/register"));
    }

    @Test
    public void shouldProcessRegistration() throws Exception {
        SpitterRepository mockRepository = mock(SpitterRepository.class);

        Spitter unsaved = new Spitter("jbauer", "24hours", "Jack", "Bauer", "jbauer@126.com");
        Spitter saved = new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer", "jbauer@126.com");

        when(mockRepository.save(unsaved)).thenReturn(saved);

        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/spitters/register")
                .param("firstName", "Jack")
                .param("lastName", "Bauer")
                .param("userName", "jbauer")
                .param("password", "24hours")
                .param("email", "jack@126.com"))
                .andExpect(redirectedUrl("/spitters/jbauer"));

        verify(mockRepository, atLeastOnce()).save(unsaved);
    }

    @Test
    public void shouldFailValidationWithNoData() throws Exception {
        SpitterRepository mockRepository = mock(SpitterRepository.class);

        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/spitters/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("spitters/register"))
                .andExpect(model().errorCount(5))
                .andExpect(model().attributeHasFieldErrors("spitterForm", "firstName", "lastName", "userName", "password", "email"));

    }
}