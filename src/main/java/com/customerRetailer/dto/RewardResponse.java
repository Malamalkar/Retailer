package com.customerRetailer.dto;

import java.util.*;

public class RewardResponse {

    private Long customerId;
    private Map<String, Integer> monthlyPoints;
    private int totalPoints;

    public RewardResponse(Long customerId, Map<String, Integer> monthlyPoints, int totalPoints) {
        this.customerId = customerId;
        this.monthlyPoints = monthlyPoints;
        this.totalPoints = totalPoints;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Map<String, Integer> getMonthlyPoints() {
        return monthlyPoints;
    }

    public int getTotalPoints() {
        return totalPoints;
    }
}
