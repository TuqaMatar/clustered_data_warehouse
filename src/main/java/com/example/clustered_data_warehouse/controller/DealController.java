package com.example.clustered_data_warehouse.controller;

import com.example.clustered_data_warehouse.model.Deal;
import com.example.clustered_data_warehouse.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deals")
public class DealController {
    private final DealService dealService;

    @Autowired
    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    @PostMapping("/import")
    public ResponseEntity<String> importDeal(@RequestBody Deal deal) {
        //add validation here

        if (dealService.getDealByUniqueId(deal.getDealUniqueId()) != null) {
            return ResponseEntity.badRequest().body("Deal with the same unique id already exists.");
        }

        dealService.saveDeal(deal);

        return ResponseEntity.ok("Deal imported successfully");
    }

}
