package org.skypro.skyshop.basket;
import java.util.*;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Map<String, List<Product>> productsByName;

    public ProductBasket() {
        productsByName = new HashMap<>();
    }
    public void addProduct(Product product) {
        productsByName.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }
    public void clear() {
        productsByName.clear();
    }
    public int getTotalPrice() {
        return productsByName.values().stream()
                .flatMap(List::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }
    public void printProductBasket() {
        if (productsByName.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        productsByName.values().stream()
                .flatMap(List::stream)
                .forEach(product -> System.out.println(product.getName() + ":" + product.getPrice()));
        System.out.println("Итого: " +getTotalPrice());
        System.out.println("Количество специальных продуктов: " + getSpecialCount());
    }
    private long getSpecialCount() {
        return productsByName.values().stream()
                .flatMap(List::stream)
                .filter(Product::isSpecial)
                .count();
    }
    public boolean nasProduct(List<Product> products, String name) {
        return products.stream()
                .anyMatch(product -> product.getName().equalsIgnoreCase(name));
    }
}
