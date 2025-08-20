package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Set;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();
        productBasket.addProduct(new SimpleProduct("Клавиатура Logitech", 15000));
        productBasket.addProduct(new DiscountedProduct("Мышь Microsoft", 1000));
        productBasket.addProduct(new SimpleProduct("Наушники Kingston", 2000));

        SearchEngine searchEngine = new SearchEngine();

        searchEngine.addItem(new Article("безпроводная клавиатура"));
        searchEngine.addItem(new Article("игровая мышь"));
        searchEngine.addItem(new Article("проводные наушники"));

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
            Searchable result1 = searchEngine.findBestMatch(query1, searchEngine.getItems());
            System.out.println("Найден подходящий объект для запроса {" + query1 + "} " + result1.getName);
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            String query2 = "Флешка";
            Searchable result2 = searchEngine.findBestMatch(query2, searchEngine.getItems());
            System.out.println("айден подходящий объект для запроса {" + query2 + "} " + result2.getName);
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        String query3 = "мышь";
        Set<Searchable> foundResults = searchEngine.search(query3);

        System.out.println("Результат поиска по запросу \"" + query3 + "\":");
        if (foundResults.isEmpty()) {
            System.out.println("Результаты не найдены");
        } else {
            for (Searchable s : foundResults) {
                System.out.println("- " + s.getName);
            }
        }

        System.out.println("Содержимое корзины: ");
        productBasket.printProductBasket();

        System.out.println("Общая стоимость козины: " + productBasket.getTotalPrice());
    }
}