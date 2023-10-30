package com.example.clustered_data_warehouse;

import com.example.clustered_data_warehouse.model.Deal;
import com.example.clustered_data_warehouse.repository.DealRepository;
import com.example.clustered_data_warehouse.service.DealService;
import jakarta.validation.ValidationException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DealServiceTest {

    @InjectMocks
    private DealService dealService;

    @Mock
    private DealRepository dealRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcessDeal_ValidDeal() {
        Deal validDeal = new Deal("12345", "USD", "EUR", "2023-10-30T12:00:00", 100.0);

        when(dealRepository.save(validDeal)).thenReturn(validDeal);

        Deal result = dealService.saveDeal(validDeal);

        verify(dealRepository, times(1)).save(validDeal);

        assertNotNull(result);
        assertEquals("12345", result.getDealUniqueId());
        assertEquals("USD", result.getFromCurrencyIsoCode());
        assertEquals("EUR", result.getToCurrencyIsoCode());
        assertEquals("2023-10-30T12:00:00", result.getDealTimestamp());
        assertEquals(100.0, result.getDealAmount(), 0.001);
    }

    @Test
    public void testProcessDeal_InvalidDeal() {
        Deal invalidDeal = new Deal("12345", "USD", "INVALID", "2023-10-30T12:00:00", 100.0);
        when(dealRepository.save(invalidDeal)).thenThrow(ValidationException.class);
        try {
            dealService.saveDeal(invalidDeal);
            fail("Expected ValidationException to be thrown");
        } catch (ValidationException e) {
            // ValidationException was expected
        }
        verify(dealRepository, times(1)).save(invalidDeal);
    }
}
