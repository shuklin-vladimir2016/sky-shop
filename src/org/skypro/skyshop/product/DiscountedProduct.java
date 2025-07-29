package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discountPercent;

    public DiscountedProduct(String name, int basePrice, int discountPercent) {
        super(name);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("азовая цена должна быть больше 0.");
        }
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Процент скидкидолжен быть в диапазоне от 0 до 100включительно");
        }
        this.discountPercent = discountPercent;
        this.basePrice = basePrice;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public int getBasePrice() {
        return basePrice;
    }
}
