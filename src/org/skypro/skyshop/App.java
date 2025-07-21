package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.exceptions.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();
        ProductBasket productBasket2 = new ProductBasket();

        Product keyboard = new Product("Клавиатура", 1500);
        Product mouse = new Product("Мышь", 1000);
        Product headphones = new Product("Наушники", 2000);

        SearchEngine searchEngine = new SearchEngine();

        List<Searchable> articles = new ArrayList<>();
        articles.add(new Article("беспроводная клавиатура"));
        articles.add(new Article("игровая мышь"));
        articles.add(new Article("проводные наушники"));

        productBasket.addProduct(mouse);
        productBasket.addProduct(keyboard);
        productBasket.addProduct(mouse);
        productBasket.addProduct(headphones);

        try {
            Product p1 = new Product("");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            SimpleProduct p2 = new SimpleProduct("Клавиатура", 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            DiscountedProduct p3 = new DiscountedProduct("Мышь", -10, 50);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            DiscountedProduct p4 = new DiscountedProduct("Наушники", 100, 150);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            String query1 = "Клавиатура";
            Searchable result1 = searchEngine.findBestMatch(query1, articles);
            System.out.println("Найден подходящий объект для запроса {" + query1 + "} " + result1);
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {String query2 = "флэшка";
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
        List<Product> removedNonExist = productBasket.removeProductByNam("Коврик");
        if (removedNonExist.isEmpty()) {
            System.out.println("список пуст");
        } else {
            System.out.println("Удалены товары из Корзины 1");
            for (Product p : removedNonExist) {
                System.out.println(p);
            }
        }
        System.out.println();
        System.out.println("Крозина 1");
        productBasket.printProductBasket();
        System.out.println("Корзина 2");
        productBasket2.printProductBasket();

    }
}