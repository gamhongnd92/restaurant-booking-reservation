package com.csis3275.group4.controller;

import com.csis3275.group4.entity.Booking;
import com.csis3275.group4.entity.Table;
import com.csis3275.group4.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private ServiceService serviceService;
    @Autowired
    private TableService tableService;
    @Autowired
    private UserService userService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private BookingService bookingService;

    public BookingController(ServiceService serviceService, TableService tableService, UserService userService, StaffService staffService, BookingService bookingService) {
        this.serviceService = serviceService;
        this.tableService = tableService;
        this.userService = userService;
        this.staffService = staffService;
        this.bookingService = bookingService;
    }

    @GetMapping
    public String booking(Model model) {
        model.addAttribute("bookings", bookingService.getAll());
        return "booking_display";
    }

    @PostMapping("/new")
    public String addBooking(@ModelAttribute("booking") Booking booking, Model model) {
        bookingService.add(booking);
        for (Table table:
             booking.getTables()) {
            tableService.updateAvailable(table.getId(), false);
        }

        return "redirect:/booking";
    }

    @GetMapping("/new")
    public String createBooking(Model model) {
        Booking booking = new Booking();
        model.addAttribute("booking", booking);
        model.addAttribute("availableServices", serviceService.getAll());
        model.addAttribute("availableTables", tableService.getAllAvailable());
        model.addAttribute("staff", staffService.getAll());
        model.addAttribute("today", LocalDate.now());

        return "booking_create";
    }

    @GetMapping("/{id}/edit")
    public String editBooking(@PathVariable("id") String Id, Model model) {
        Booking booking = this.bookingService.findById(Id);
        List<Table> availableTables = this.tableService.getAllAvailable();

        // add all available tables
        availableTables.addAll(booking.getTables());
        booking.setTables(availableTables);

        model.addAttribute("booking", booking);
        model.addAttribute("bookingId", Id);
        model.addAttribute("availableServices", serviceService.getAll());
        model.addAttribute("today", LocalDate.now());
        return "booking_edit";
    }

    @PostMapping("/{id}/edit")
    public String updateBooking(@PathVariable("id") String Id, @ModelAttribute("booking") Booking booking, Model model) {

        bookingService.update(Id, booking);
        for (Table table:
                booking.getTables()) {
            tableService.updateAvailable(table.getId(), false);
        }

        return "redirect:/booking";
    }

    @GetMapping("/{id}/delete")
    public String deleteBooking(@PathVariable("id") String Id, Model model) {

        Booking booking = this.bookingService.findById(Id);
        if (booking != null) {
            for (Table table :
                    booking.getTables()) {
                tableService.updateAvailable(table.getId(), true);
            }
            this.bookingService.delete(Id);
        }
        return "redirect:/booking";
    }
}
