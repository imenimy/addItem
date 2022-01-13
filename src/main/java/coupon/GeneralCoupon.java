package coupon;

import java.math.BigDecimal;

// coupon that should apply on all items
public class GeneralCoupon implements Coupon {
    int percentage;

    public GeneralCoupon(int percentage) {
        this.percentage = percentage;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public BigDecimal apply(BigDecimal price) {
        return price.subtract((price.multiply(BigDecimal.valueOf(this.percentage))).divide(BigDecimal.valueOf(100L)));
    }
}