package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.exceptions.*;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Map;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();
        ProductBasket productBasket2 = new ProductBasket();

        Product keyboard = new Product("Клавиатура", 1500);
        Product mouse = new Product("Мышь", 1000);
        Product headphones = new Product("Наушники", 2000);

        SearchEngine searchEngine = new SearchEngine();


        searchEngine.add(new MySearchable("беспроводная клавиатура"));
        searchEngine.add(new MySearchable("игровая мышь"));
        searchEngine.add(new MySearchable("проводные наушники"));

        productBasket.addProduct(keyboard);
        productBasket.addProduct(mouse);
        productBasket.addProduct(keyboard);
        productBasket.addProduct(headphones);

        Map<String, Searchable> results = searchEngine.search("мышь");

        if (results.isEmpty()) {
            System.out.println("Результат не найден");
        } else {
            System.out.println("Найденные результаты");
            for (Map.Entry<String, Searchable> entry : results.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
        try {
            Product p1 = new Product("Мышь");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            SimpleProduct p2 = new SimleProduct("Мышь", 1000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            DiscountedProduct p3 = new DiscountedProduct("Клавиатура", -10, 50);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            DiscountedProduct p4 = new DiscountedProduct("Наушники", 100, 150);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            String query1 = "Мышь";
            System.out.println("Найден подходящий объект для запроса {" + query1 + "} " + result1);
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {String query2 = "флэшка";
            System.out.println("Найден подходящий объект для запроса {" + query2 + "} " + result2);
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println();
        System.out.println("Корзина 1");
        productBasket.printProductBasket();
        System.out.println("Корзина 2");
        productBasket2.printProductBasket();

        System.out.println();
        List<Product> removed = productBasket.removeProductByName("Клавиатура");
        System.out.println("Удалены товары из Корзины 1: ");
        for (Product p : removed) {
            System.out.println(p);
        }
        System.out.println();
        List<Product> removedNonExist = productBasket.removeProductByName("Коврик");
        if (removedNonExist.isEmpty()) {
            System.out.println("список пуст");
        } else {
            System.out.println("Удалены товары из Корзины 1");
            for (Product p : removedNonExist) {
                System.out.println(p);
            }
        }
        System.out.println();
        System.out.println("Корзина 1");
        productBasket.printProductBasket();
        System.out.println("Корзина 2");
        productBasket2.printProductBasket();
    }
}