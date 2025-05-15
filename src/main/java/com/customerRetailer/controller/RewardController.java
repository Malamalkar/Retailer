package com.customerRetailer.controller;

import com.customerRetailer.dto.RewardResponse;
import com.customerRetailer.exception.InvalidPurchaseAmountException;
import com.customerRetailer.model.Transaction;
import com.customerRetailer.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
  * REST controller that handles reward points calculation requests.
 * Accepts purchase amount input and returns the calculated reward points.
 */

@RestController
@RequestMapping("api/rewards")
public class RewardController {

    @Autowired
    private RewardService rewardService;

    @PostMapping("/calculateRewards")
    public List<RewardResponse> calculateRewards(@RequestBody List<Transaction> transactions) {

       return rewardService.calculateRewardPoints(transactions);

    }

    @GetMapping("/calculate")
    public String calculate(){
        return "hello";

    }


}
