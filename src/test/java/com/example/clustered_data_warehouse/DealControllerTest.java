package com.example.clustered_data_warehouse;

import com.example.clustered_data_warehouse.controller.DealController;
import com.example.clustered_data_warehouse.model.Deal;
import com.example.clustered_data_warehouse.service.DealService;
import jakarta.validation.ValidationException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import static org.mockito.Mockito.*;

public class DealControllerTest {

    @InjectMocks
    private DealController dealController;

    @Mock
    private DealService dealService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcessDeal_ValidDeal() {
        Deal validDeal = new Deal("12345", "USD", "EUR", "2023-10-30T12:00:00", 100.0);

        when(dealService.saveDeal(validDeal)).thenReturn(validDeal);

        ResponseEntity<String> response = dealController.importDeal(validDeal);

        verify(dealService, times(1)).saveDeal(validDeal);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Deal processed successfully", response.getBody());
    }

    @Test
    public void testProcessDeal_InvalidDeal() {
        Deal invalidDeal = new Deal("12345", "USD", "INVALID", "2023-10-30T12:00:00", 100.0);

        when(dealService.saveDeal(invalidDeal)).thenThrow(ValidationException.class);

        ResponseEntity<String> response = dealController.importDeal(invalidDeal);

        verify(dealService, times(1)).saveDeal(invalidDeal);

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}
