package org.skypro.skyshop.product;

import org.skypro.skyshop.product.Product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String name, int price) {
        super(name);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена продукта должна быть больше 0.");
        }
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
