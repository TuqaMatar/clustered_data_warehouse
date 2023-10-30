package com.example.clustered_data_warehouse.service;
import com.example.clustered_data_warehouse.model.Deal;
import com.example.clustered_data_warehouse.repository.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DealService {
    private final DealRepository dealRepository;

    @Autowired
    public DealService(DealRepository dealRepository) {
        this.dealRepository = dealRepository;
    }

    public Deal saveDeal(Deal deal) {
        return dealRepository.save(deal);
    }

    public Deal getDealByUniqueId(String dealUniqueId) {
        return dealRepository.findByDealUniqueId(dealUniqueId);
    }

}
