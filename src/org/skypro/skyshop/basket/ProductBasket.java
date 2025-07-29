package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> products;

    public ProductBasket() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        String name = product.getName();
        products.computeIfAbsent(name, k -> new ArrayList<>()).add(product);
    }

    public List<Product> removeProductByName(String name) {
        List<Product> removedProduct = products.remove(name);
        return removedProduct != null ? removedProduct : new ArrayList<>();
    }

    public int getTotalPrice() {
        int total = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void printProductBasket() {
        boolean isEmpty = true;
        int specialCount = 0;
        for (List<Product> productList : products.values()) {
            if (!productList.isEmpty()) {
                isEmpty = false;
                break;
            }
        }
        if (products.isEmpty() || isEmpty) {
            System.out.println("В корзине пусто");
        } else {
            for (List<Product> productList : products.values()) {
                for (Product product : productList) {
                    if (product != null) {
                        System.out.println(product);
                    }
                }
            }
            for (List<Product> productList : products.values()) {
                for (Product product : productList) {
                    if (product != null && product.isSpecial()) {
                        specialCount++;
                    }
                }
            }
            System.out.println("Итого: " + getTotalPrice());
            System.out.println("Специальных товаров: " + specialCount);
        }
    }

    public boolean hasProduct(String name) {
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }
}