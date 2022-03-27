package com.csis3275.group4.controller;

import com.csis3275.group4.entity.Table;
import com.csis3275.group4.repository.TableRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TableControllerTest {
    TableRepository tableRepository;

    @Test
    public void checkValidateTable() {
        TableController tableController = new TableController(tableRepository);
        boolean result = tableController.checkTable(new Table("Table12", 1, true));
        assertFalse(result);

        result = tableController.checkTable(new Table("Table13", 10, true));
        assertTrue(result);
    }


}