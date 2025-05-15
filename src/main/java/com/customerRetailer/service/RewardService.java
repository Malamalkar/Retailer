package com.customerRetailer.service;

import com.customerRetailer.dto.RewardResponse;
import com.customerRetailer.exception.InvalidPurchaseAmountException;
import com.customerRetailer.model.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RewardService {

    public List<RewardResponse> calculateRewardPoints(List<Transaction> transactions) {
        Map<Long, Map<String, Integer>> rewards = new HashMap<>();

        for (Transaction trans : transactions) {
           try {
               int points = calculatePoints(trans.getAmount());
               String month=trans.getDate().getMonth().toString();
               rewards.putIfAbsent(trans.getCustomerId(), new HashMap<>());
               Map<String,Integer> customerRewards=rewards.get(trans.getCustomerId());
               customerRewards.put(month,customerRewards.getOrDefault(month,0)+points);
           }catch (InvalidPurchaseAmountException e)
           {
               System.err.println("Error: " + e.getMessage());
           }
        }
        return rewards.entrySet().stream().map(entry->{
            Long CustId=entry.getKey();
            Map<String,Integer> monthlyData=entry.getValue();
            int total =monthlyData.values().stream().mapToInt(Integer::intValue).sum();
             return new RewardResponse(CustId,monthlyData,total);
        }).collect(Collectors.toList());
    }

//    public int calculatPoint(int amount) {
//        int point = 0;
//        if (amount > 100) {
//            point += (amount - 100) * 2;
//        } if (amount > 50) {
//            point += (amount - 50);
//        }
//        return point;
//
//    }

    public static int calculatePoints(double totalPurchase) {
        if (totalPurchase < 0) {
            throw new InvalidPurchaseAmountException("Purchase amount cannot be negative.");
        }
        if (totalPurchase == 0) {
            throw new InvalidPurchaseAmountException("Purchase amount cannot be zero.");
        }

        int points = 0;

        // If the purchase is more than $100, calculate based on the rules
        if (totalPurchase > 100) {
            // Points for the first $50 (1 point per dollar)
            points += 50; // 1 point per dollar for the first $50

            // Points for the remaining amount over $100 (2 points per dollar)
            points += (int) ((totalPurchase - 100) * 2); // 2 points per dollar above $100
        }
        // If the purchase is between $50 and $100
        else if (totalPurchase > 50) {
            points += (int) totalPurchase; // 1 point per dollar for the full amount
        }
        // If the purchase is $50 or below, no points are awarded
        return points;
    }

}
