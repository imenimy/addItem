package product;

import java.math.BigDecimal;

public class CartItem {
    ProductType productType;
    BigDecimal price;


    public CartItem(ProductType productType, BigDecimal price) {
        this.productType = productType;
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}