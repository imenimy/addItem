import java.math.BigDecimal;
import java.util.ArrayList;
import coupon.*;
import product.*;


public class Main {


    public BigDecimal solution (ArrayList<CartItem> items, ArrayList<Coupon> coupons) {

        BigDecimal totalPrice;

        for (Coupon c: coupons) {
            if (c instanceof GeneralCoupon) {
                items.forEach(item -> {
                    item.setPrice(c.apply(item.getPrice()));
                });

            }
            if (c instanceof NextItemCoupon) {
                items.get(((NextItemCoupon) c).getNextProduct()).setPrice(c.apply(items.get(((NextItemCoupon) c).getNextProduct()).getPrice()));
            }

            if (c instanceof NthProductCoupon) {
                int occurence = 0;
                for (CartItem item: items) {
                    if (item.getProductType() == ((NthProductCoupon) c).getProductType()) {
                        occurence += 1;
                    }
                    if (occurence == ((NthProductCoupon) c).getQuantity()) {
                        item.setPrice(c.apply(item.getPrice()));
                        break;
                    }
                }
            }
        }


        totalPrice = items.stream().map(CartItem::getPrice).reduce(BigDecimal::add).get();

        return totalPrice;

    }

}
