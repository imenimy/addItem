package coupon;

import product.ProductType;
import java.math.BigDecimal;

public class NthProductCoupon implements Coupon {
    BigDecimal amount;
    ProductType productType;
    int quantity;

    public NthProductCoupon(BigDecimal amount, ProductType productType, int quantity) {
        this.amount = amount;
        this.productType = productType;
        this.quantity = quantity;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal apply(BigDecimal price) {
        return price.subtract(amount);
    }
}

