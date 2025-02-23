package com.example.trading.controllers;

import com.example.trading.models.Trade;
import com.example.trading.services.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trades")
public class TradeController {

    @Autowired
    private TradeService tradeService;

    @PostMapping
    public Trade createTrade(@RequestBody Trade trade) {
        return tradeService.createTrade(trade);
    }

    @GetMapping("/{id}")
    public Trade getTradeById(@PathVariable Long id) {
        return tradeService.getTradeById(id);
    }

    @GetMapping("/user/{username}")
    public List<Trade> getTradesByUsername(@PathVariable String username) {
        return tradeService.getTradesByUsername(username);
    }

    @GetMapping
    public List<Trade> getAllTrades() {
        return tradeService.getAllTrades();
    }

    @DeleteMapping("/{id}")
    public String deleteTrade(@PathVariable Long id) {
        tradeService.deleteTrade(id);
        return "Trade deleted successfully";
    }
}
