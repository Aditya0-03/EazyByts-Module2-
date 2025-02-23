package com.example.trading.controllers;

import com.example.trading.services.StockService; // Ensure this is present
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public String[] getStocks() {
        return stockService.getStockSymbols();
    }
}
