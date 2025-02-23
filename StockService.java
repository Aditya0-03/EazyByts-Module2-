package com.example.trading.services;

import org.springframework.stereotype.Service;

@Service
public class StockService {
    
    public String[] getStockSymbols() {
        return new String[]{"AAPL", "GOOGL", "TSLA"};
    }
}
