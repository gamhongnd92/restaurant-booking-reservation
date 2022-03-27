package com.csis3275.group4.controller;

import com.csis3275.group4.entity.Service;
import com.csis3275.group4.repository.ServiceRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServiceControllerTest {
    ServiceRepository serviceRepository;

    @Test
    public void checkServiceTest(){
        ServiceController serviceController = new ServiceController(serviceRepository);
        boolean result = serviceController.checkService(new Service("Small Party", 70));
        assertTrue(result);

        result = serviceController.checkService(new Service("Small Party", 700));
        assertFalse(result);
    }

}