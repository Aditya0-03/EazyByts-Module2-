package com.example.trading.services;

import com.example.trading.models.Trade;
import com.example.trading.repositories.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeService {

    @Autowired
    private TradeRepository tradeRepository;

    public Trade createTrade(Trade trade) {
        return tradeRepository.save(trade);
    }

    public Trade getTradeById(Long id) {
        return tradeRepository.findById(id)
                .orElseThrow(() -> new TradeNotFoundException("Trade with ID " + id + " not found"));
    }

    public List<Trade> getTradesByUsername(String username) {
        return tradeRepository.findByUsername(username);
    }

    public List<Trade> getAllTrades() {
        return tradeRepository.findAll();
    }

    public void deleteTrade(Long id) {
        if (!tradeRepository.existsById(id)) {
            throw new TradeNotFoundException("Trade with ID " + id + " not found");
        }
        tradeRepository.deleteById(id);
    }
}
