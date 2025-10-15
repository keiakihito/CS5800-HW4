package restaurant.loyalty;

/**
 * Represents customer loyalty status and applies discounts.
 * Different loyalty levels(Silver, Gold, Platinum) provide different discount percentages (5%, 10%, 15%).
 * None loyalty level provides no discount.
 */
public class LoyaltyDiscount {
    private String _loyaltyLevel;
    private double _discountRate;
    
    public LoyaltyDiscount(String loyaltyLevel) {
        _loyaltyLevel = loyaltyLevel;
        setDiscountRate(loyaltyLevel);
    }

    private void setDiscountRate(String loyaltyLevel) {
        switch (loyaltyLevel) {
            case "None":
                _discountRate = 0.0;
                break;
            case "Silver":
                _discountRate = 0.05;
                break;
            case "Gold":
                _discountRate = 0.10;
                break;
            case "Platinum":
                _discountRate = 0.15;
                break;
            default:
                _discountRate = 0.0;
                break;
        }
    }
    
    public double getDiscountRate() {
        return _discountRate;
    }
    
    public String getLoyaltyLevel() {
        return _loyaltyLevel;
    }
    
    public double applyDiscount(double amount) {
        return amount * (1 - _discountRate);
    }


}
