package org.skypro.skyshop.product;

public class Product {
    private final String name;
    int price;

    public Product(String name, int price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("название продукта не может быть пустым, состоять только из пробелов или быть null");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return "Product { " + name + ": " + " стоимость = " + price + "}";
    }
}
