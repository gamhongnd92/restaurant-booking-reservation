package com.csis3275.group4.controller;

import com.csis3275.group4.entity.Staff;
import com.csis3275.group4.repository.StaffRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class StaffControllerTest {
    StaffRepository staffRepository;

    @Test
    public void checkValidateStaff(){
        StaffController staffController = new StaffController(staffRepository);
        boolean result = staffController.checkStaff(new Staff("John", LocalDate.of(1980, 01, 01), "2168 15th Ave E Vancouver, BC", Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")));
        assertTrue(result);

        result = staffController.checkStaff(new Staff("John", LocalDate.of(1960, 01, 01), "2168 15th Ave E Vancouver, BC", Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")));
        assertFalse(result);
    }

}