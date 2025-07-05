package org.skypro.skyshop.basket;

import java.util.Arrays;
import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products;
    private int size;

    public ProductBasket(int basket) {
        products = new Product[basket];
        size = 0;
    }
    public void addProduct(Product product) {
        System.out.println("Невозможно добавить продукт");
        if (size < products.length) {
            products[size] = product;
            size++;
        } else {
        }
    }
    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < size; i++) {
            total += products[i].getPrice();
        }
        return total;
    }
    public void printProductBasket() {
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getName() + ": " + product.getPrice());
            }
        }
        System.out.println("Итого: " + getTotalPrice());
    }

    public void clear() {
        Arrays.fill(products, null);
    }
}
