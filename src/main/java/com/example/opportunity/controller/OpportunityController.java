package com.example.opportunity.controller;

import com.example.opportunity.model.OpportunityDTO;
import com.example.opportunity.service.SalesforceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OpportunityController {

    private final SalesforceService salesforceService;

    public OpportunityController(SalesforceService salesforceService) {
        this.salesforceService = salesforceService;
    }

    @GetMapping("/getAllTasks")
    public List<OpportunityDTO> getAllTasks() {
        return salesforceService.fetchOpportunities();
    }
}
