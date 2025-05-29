package com.customerRetailer;

import com.customerRetailer.exception.InvalidPurchaseAmountException;
import com.customerRetailer.service.RewardService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RewardTest {
    @Test
    void testPurchaseBelowZero_ThrowsException() {
        Exception exception = assertThrows(InvalidPurchaseAmountException.class, () ->
                RewardService.calculatePoints(-10)
        );
        assertEquals("Purchase amount cannot be negative.", exception.getMessage());
    }

    @Test
    void testPurchaseIsZero_ThrowsException() {
        Exception exception = assertThrows(InvalidPurchaseAmountException.class, () ->
                RewardService.calculatePoints(0)
        );
        assertEquals("Purchase amount cannot be zero.", exception.getMessage());
    }

    @Test
    void testPurchaseLessThan50_GivesZeroPoints() {
        int points = RewardService.calculatePoints(40);
        assertEquals(0, points);
    }

    @Test
    void testPurchaseExactly50_GivesZeroPoints() {
        int points = RewardService.calculatePoints(50);
        assertEquals(0, points);
    }

    @Test
    void testPurchaseBetween50And100_GivesPointsEqualToAmount() {
        int points = RewardService.calculatePoints(75);
        assertEquals(75, points); // full amount
    }

    @Test
    void testPurchaseExactly100_Gives100Points() {
        int points = RewardService.calculatePoints(100);
        assertEquals(100, points); // 1 point per dollarppp
        
    }

    @Test
    void testPurchaseAbove100_CalculatesCorrectly() {
        int points = RewardService.calculatePoints(120);
        // 50 points for first $50
        // 20 * 2 = 40 points for amount over $100
        // Total: 50 + 40 = 90
        assertEquals(90, points);
    }

    @Test
    void testPurchaseJustOver100() {
        int points = RewardService.calculatePoints(101);
        // 50 + 2 = 52
        assertEquals(52, points);
    }

    @Test
    void testPurchaseHighAmount() {
        int points = RewardService.calculatePoints(200);
        // 50 points for $50
        // 100 * 2 = 200 points
        // Total: 250
        assertEquals(250, points);
    }

}
