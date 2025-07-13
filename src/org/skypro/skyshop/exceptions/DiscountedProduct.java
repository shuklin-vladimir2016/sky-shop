package org.skypro.skyshop.exceptions;

import org.skypro.skyshop.product.Product;

public class DiscountedProduct extends Pruduct {
    private final int basePrice;
    private final int discountPercent;

    public DiscountedProduct(String name, int basePrice, int discountPercent) {
        super(name);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Базовая цена должна быть больше 0.");
        }
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть в диапозоне от 0 до 100 включительно");
        }
        this.basePrice = basePrice;
        this.discountPercent = discountPercent;
    }

    public int getBasePrice() {
        return  basePrice;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }
}
