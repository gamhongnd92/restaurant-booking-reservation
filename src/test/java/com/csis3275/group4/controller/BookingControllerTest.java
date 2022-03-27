package com.csis3275.group4.controller;

import com.csis3275.group4.entity.Booking;
import com.csis3275.group4.service.BookingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private  BookingService bookingService;

    @Test
    public void booking() throws Exception {
        Booking first = new Booking();
        Booking second = new Booking();
        when(bookingService.getAll()).thenReturn(Arrays.asList(first,second));
        mockMvc.perform(get("/booking"))
                .andExpect(status().isOk())
                .andExpect(view().name("booking_display"))
                .andExpect(model().attribute("bookings",hasSize(2)))
                .andExpect(model().attribute("bookings",hasItem(first)))
                .andExpect(model().attribute("bookings",hasItem(second)));
    }
    @Test
    public void editBooking() throws Exception{
        Booking first = new Booking();
        first.setId("001");
        when(bookingService.findById("001")).thenReturn(first);
        mockMvc.perform(get("/booking/001/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("booking_edit"))
                .andExpect(model().attribute("bookingId",is("001")))
                .andExpect(model().attribute("today",is(LocalDate.now())))
                .andExpect(model().attribute("booking",hasProperty("id",is("001"))));
    }

    @Test
    public void deleteBooking() throws Exception{
        Booking first = new Booking();
        first.setId("001");
        when(bookingService.findById("001")).thenReturn(first);
        mockMvc.perform(get("/booking/001/delete"));
        verify(bookingService,times(1)).delete("001");
    }
    @Test
    public void updateBooking() throws Exception{
        Booking first = new Booking();
        first.setId("001");
        mockMvc.perform(post("/booking/001/edit"));
        //verify(bookingService,times(1)).update("001",null);
    }
}