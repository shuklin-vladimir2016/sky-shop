package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.exceptions.*;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.search.MySearchable;

import java.util.Set;

public class App {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine();

        searchEngine.addItem(new MySearchable("Клавиатура Logitech"));
        searchEngine.addItem(new MySearchable("Мышь Microsoft"));
        searchEngine.addItem(new MySearchable("Наушники Kingston"));

        Set<Searchable> results = searchEngine.search("Клавиатура");

        if (results.isEmpty()) {
            System.out.println("Результаты не найдены");
        } else {
            for (Searchable result : results) {
                System.out.println(result.getName());
            }
        }

        searchEngine.addItem(new Article("беспрроводная клавиатура"));
        searchEngine.addItem(new Article("игровая мышь"));
        searchEngine.addItem(new Article("проводные наушники"));

        System.out.println("\n" + searchEngine);

        Set<Searchable> found = searchEngine.search("Мышь");

        System.out.println("Отсортированные результаты поиска: ");
        for (Searchable item : found) {
            System.out.println(item.getName());
        }
        System.out.println();

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
            System.out.println("Найден подходящий объект для запроса {" + query1 + "} " + result1);
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            String query2 = "Флэшка";
            Searchable result2 = searchEngine.findBestMatch(query2, searchEngine.getItems());
            System.out.println("Найден подходящий объект для запроса {" + query2 + "} " + result2);
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}