package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final List<Product> products;

    public ProductBasket() {
        products = new ArrayList<>();
    }
    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> removeProductByName(String name) {
        List<Product> removedProduct = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                removedProduct.add(product);
                iterator.remove();

            }
        }
        return removedProduct;
    }

    public int getTotalPrice() {
        int total = 0;
        for (Product product : products) {
            if (products != null) {
                total += product.getPrice();
            }
        }
        return total;
    }
    public void printProductBasket() {
        int specialCount = 0;
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            for (Product product : products) {
                if (product != null) {
                    System.out.println(product);
                }
            }
            for (Product product : products) {
                if (product != null && product.isSpecial()) {
                    specialCount++;
                }
            }

            System.out.println("Итого: " + getTotalPrice());
            System.out.println("Специальных товаров: " + specialCount);
        }
    }

    public boolean nasProduct(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        Arrays.fill(products, null);
    }
}
