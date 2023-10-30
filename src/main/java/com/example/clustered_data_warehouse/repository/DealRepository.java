package com.example.clustered_data_warehouse.repository;

import com.example.clustered_data_warehouse.model.Deal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealRepository extends MongoRepository<Deal, String> {
    Deal findByDealUniqueId(String dealUniqueId);
}
