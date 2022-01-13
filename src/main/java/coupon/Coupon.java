package coupon;

import java.math.BigDecimal;

public interface Coupon {
    BigDecimal apply(BigDecimal price);
}