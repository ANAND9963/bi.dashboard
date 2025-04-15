package com.joy.bi.dashboard.controller;

import com.joy.bi.dashboard.dto.TopSellingItemDTO;
import com.joy.bi.dashboard.service.TopSellingItemsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/warehouse/top-selling")
public class TopSellingItemsController {

    private final TopSellingItemsService topSellingItemsService;

    public TopSellingItemsController(TopSellingItemsService topSellingItemsService) {
        this.topSellingItemsService = topSellingItemsService;
    }

    @GetMapping
    public List<TopSellingItemDTO> getTopSellingItems() {
        return topSellingItemsService.getTopSellingItems();
    }
}