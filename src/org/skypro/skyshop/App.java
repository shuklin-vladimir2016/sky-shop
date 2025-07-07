package org.skypro.skyshop;

 import org.skypro.skyshop.product.Product;
 import org.skypro.skyshop.basket.ProductBasket;
 import org.skypro.skyshop.product.SimpleProduct;
 import org.skypro.skyshop.product.DiscountedProduct;
 import org.skypro.skyshop.product.FixPriceProduct;
 import java.util.List;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket(5);

        DiscountedProduct apple = new DiscountedProduct("Яблоко", 40, 5);
        SimpleProduct banana = new SimpleProduct("Банан", 30);
        FixPriceProduct orange = new FixPriceProduct("Апельсин");
        SimpleProduct cherry = new SimpleProduct("Вишня", 70);
        SimpleProduct grape = new SimpleProduct("Виноград", 60);

        productBasket.addProduct(apple);
        productBasket.addProduct(banana);
        productBasket.addProduct(orange);
        productBasket.addProduct(cherry);
        productBasket.addProduct(grape);

        System.out.println();
        productBasket.printProductBasket();

        productBasket.clear();
    }
}