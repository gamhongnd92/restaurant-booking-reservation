package com.csis3275.group4;


import com.csis3275.group4.controller.BookingController;
import com.csis3275.group4.entity.Booking;
import com.csis3275.group4.entity.Customer;
import com.csis3275.group4.service.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;

import java.awt.print.Book;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@AutoConfigureMockMvc
//@SpringBootTest
@WebMvcTest(BookingController.class)
public class BookingControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;
    @MockBean
    private ServiceService serviceService;
    @MockBean
    private TableService tableService;
    @MockBean
    private UserService userService;
    @MockBean
    private StaffService staffService;
    @MockBean
    private BookingService bookingService;
    @MockBean
    private Model model;

    @Autowired
    private ObjectMapper objectMapper;


    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private BookingController bookingController;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void bookingDisplay() throws Exception {
        mockMvc.perform(get("/booking")).andExpect(status().isOk());
    }

    @Test
    public void addBooking() throws Exception {

        Booking booking = new Booking();
        Customer customer = new Customer("CustomerName", "CustomerPhone");
        booking.setCustomer(customer);

        ArgumentCaptor<Booking> bookingArgumentCaptor = ArgumentCaptor.forClass(Booking.class);
        MvcResult mvcResult = mockMvc.perform(
                post("/booking/new")
                        .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
                        .content(objectMapper.writeValueAsString(booking))
                        .flashAttr("booking", booking)
        )
                .andReturn();

        String actualResponseBody = mvcResult.getResponse().getContentAsString();

        verify(bookingService, times(1))
                .add(bookingArgumentCaptor.capture());

        assertThat(bookingArgumentCaptor.getValue().getCustomer().getCustomerName()).isEqualTo(booking.getCustomer().getCustomerName());
        assertThat(bookingArgumentCaptor.getValue().getCustomer().getCustomerPhone()).isEqualTo(booking.getCustomer().getCustomerPhone());

    }
}
