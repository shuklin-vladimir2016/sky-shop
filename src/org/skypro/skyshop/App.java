package org.skypro.skyshop;

 import org.skypro.skyshop.product.Product;
 import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket(5);

        Product apple = new Product("Яблоко", 50);
        Product banana = new Product("Банан", 30);
        Product orange = new Product("Апельсин", 40);
        Product cherry = new Product("Вишня", 70);
        Product grape = new Product("Виноград", 60);

        productBasket.addProduct(apple);
        productBasket.addProduct(banana);
        productBasket.addProduct(orange);
        productBasket.addProduct(cherry);
        productBasket.addProduct(grape);

        System.out.println();
        productBasket.printProductBasket();

        productBasket.clear();
        productBasket.printProductBasket();
    }
}