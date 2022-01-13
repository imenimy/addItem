package coupon;

import java.math.BigDecimal;

public class NextItemCoupon implements Coupon {
    int nextProduct; // to identify next item index
    int percentage;

    public NextItemCoupon(int nextProduct, int percentage) {
        this.nextProduct = nextProduct;
        this.percentage = percentage;
    }

    public int getNextProduct() {
        return nextProduct;
    }

    public void setNextProduct(int nextProduct) {
        this.nextProduct = nextProduct;
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
