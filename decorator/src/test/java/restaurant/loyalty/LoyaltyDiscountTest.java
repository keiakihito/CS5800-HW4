package restaurant.loyalty;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for LoyaltyDiscount class.
 */
public class LoyaltyDiscountTest {

    @Test
    public void testNoLoyaltyDiscount() {
        LoyaltyDiscount noLoyalty = new LoyaltyDiscount("None");
        assertEquals(0.0, noLoyalty.getDiscountRate(), 0.01);
    }

    @Test
    public void testSilverLoyaltyDiscount() {
        LoyaltyDiscount silver = new LoyaltyDiscount("Silver");
        assertEquals(0.05, silver.getDiscountRate(), 0.01);
    }

    @Test
    public void testGoldLoyaltyDiscount() {
        LoyaltyDiscount gold = new LoyaltyDiscount("Gold");
        assertEquals(0.10, gold.getDiscountRate(), 0.01);
    }

    @Test
    public void testPlatinumLoyaltyDiscount() {
        LoyaltyDiscount platinum = new LoyaltyDiscount("Platinum");
        assertEquals(0.15, platinum.getDiscountRate(), 0.01);
    }

    @Test
    public void testApplyDiscountToAmount() {
        LoyaltyDiscount gold = new LoyaltyDiscount("Gold");
        double originalAmount = 100.0;
        double discountedAmount = gold.applyDiscount(originalAmount);
        assertEquals(90.0, discountedAmount, 0.01);
    }

    @Test
    public void testApplyNoDiscount() {
        LoyaltyDiscount noLoyalty = new LoyaltyDiscount("None");
        double originalAmount = 100.0;
        double discountedAmount = noLoyalty.applyDiscount(originalAmount);
        assertEquals(100.0, discountedAmount, 0.01);
    }

    @Test
    public void testGetTier() {
        LoyaltyDiscount silver = new LoyaltyDiscount("Silver");
        assertEquals("Silver", silver.getTier());
    }
}
