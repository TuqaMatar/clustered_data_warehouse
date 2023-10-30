package com.example.clustered_data_warehouse.controller;

import com.example.clustered_data_warehouse.model.Deal;
import com.example.clustered_data_warehouse.service.DealService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/deals")
public class DealController {
    private final DealService dealService;
    private final Logger logger = LoggerFactory.getLogger(DealController.class);


    @Autowired
    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    @PostMapping("/import")
    public ResponseEntity<String> importDeal(@RequestBody @Valid Deal deal ) {
        logger.trace("access import Deal");
        if (dealService.getDealByUniqueId(deal.getDealUniqueId()) != null) {
            logger.trace("same unique id exists for deal:"+ deal.getDealUniqueId());
            return ResponseEntity.badRequest().body("Deal with the same unique id already exists.");
        }

        dealService.saveDeal(deal);
        logger.trace("saved Deal");
        return ResponseEntity.ok("Deal processed successfully");

    }

}


