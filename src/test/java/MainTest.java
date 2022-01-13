import coupon.Coupon;
import coupon.GeneralCoupon;
import coupon.NextItemCoupon;
import coupon.NthProductCoupon;
import product.CartItem;
import product.ProductType;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

public class MainTest {

    @Test
    public void testCart1() {

        ArrayList<CartItem> items = new ArrayList();
        ArrayList<Coupon> coupons = new ArrayList();
        coupons.add(new NextItemCoupon(items.size(), 10));
        items.add(new product.CartItem(product.ProductType.POSTCARD_SORTER, BigDecimal.TEN));
        items.add(new product.CartItem(product.ProductType.STATIONERY_ORGANIZER, new BigDecimal(20)));


        Assert.assertEquals(BigDecimal.valueOf(29), new Main().solution(items, coupons));
    }

    @Test
    public void testCart2() {

        ArrayList<CartItem> items = new ArrayList();
        ArrayList<Coupon> coupons = new ArrayList();

        items.add(new product.CartItem(product.ProductType.POSTCARD_SORTER, BigDecimal.TEN));
        coupons.add(new NextItemCoupon(items.size(), 10));
        items.add(new product.CartItem(product.ProductType.STATIONERY_ORGANIZER, new BigDecimal(20)));

        Assert.assertEquals(BigDecimal.valueOf(28), new Main().solution(items, coupons));
    }

    @Test
    public void testCart3() {

        ArrayList<CartItem> items = new ArrayList();
        ArrayList<Coupon> coupons = new ArrayList();

        items.add(new CartItem(ProductType.POSTCARD_SORTER, BigDecimal.TEN));
        coupons.add(new NthProductCoupon(BigDecimal.valueOf(2), ProductType.POSTCARD_SORTER, 2));
        coupons.add(new GeneralCoupon(25));
        coupons.add(new NextItemCoupon(items.size(), 10));
        items.add(new CartItem(ProductType.POSTCARD_SORTER, new BigDecimal(10)));

        Assert.assertEquals(BigDecimal.valueOf(12.9), new Main().solution(items, coupons));
    }
}
