package org.skypro.skyshop.product;

public abstract class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым, состоять только из пробелов или быть null.");
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

    @Override
    public String toString() {
        return "Product{ " + name + ": " + " стоимость = " + price + "}";
    }
}
