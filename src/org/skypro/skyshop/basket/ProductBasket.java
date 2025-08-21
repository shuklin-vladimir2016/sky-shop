package org.skypro.skyshop.basket;
import java.util.Arrays;
import java.util.List;
import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products;
    private int size;

    public ProductBasket(int basket) {
        products = new Product[basket];
        size = 0;
    }
    public void addProduct(Product product) {
        if (size < products.length) {
            products[size] = product;
            size++;
        } else {
            System.out.println("Не возможно добавить продукт");
        }
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
        if (size == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        for (Product product: products) {
            if (product != null) {
                System.out.println(product);
            }
            if (product != null && product.isSpecial()) {
                specialCount++;
            }
        }
        System.out.println("Итого: " + getTotalPrice());
            System.out.println("Специальных товаров: " + specialCount);
    }
    public boolean nasProduct(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}
