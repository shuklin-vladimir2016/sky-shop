package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import java.util.Arrays;


public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket(5);
        SearchEngine searchEngine = new SearchEngine(10);

        DiscountedProduct apple = new Product("Яблоко", 40, 5);
        SimpleProduct banana = new Product("Банан", 30);
        FixPriceProduct orange = new Product("Апельсин");
        SimpleProduct cherry = new Product("Вишня", 70);
        SimpleProduct grape = new Product("Виноград", 60);

        productBasket.addProduct(apple);
        productBasket.addProduct(banana);
        productBasket.addProduct(orange);
        productBasket.addProduct(cherry);
        productBasket.addProduct(grape);


        searchEngine.add(apple);
        searchEngine.add(banana);
        searchEngine.add(orange);
        searchEngine.add(cherry);
        searchEngine.add(grape);

        Article article1 = new Article("Яблоко", "Сладкий сорт");
        Article article2 = new Article("Банан", "Из Марокко");
        Article article3 = new Article("Апельсин", "Тропический вкус");
        Article article4 = new Article("Вишня", "Спелая ягода");
        Article article5 = new Article("Виноград", "Юхный аромат");

        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);
        searchEngine.add(article5);


        searchAndPrint(searchEngine, "Яблоки");
        searchAndPrint(searchEngine, "Бананы");
        searchAndPrint(searchEngine, "Апельсины");
        searchAndPrint(searchEngine, "Вишня");
        searchAndPrint(searchEngine, "Виноград");
        searchAndPrint(searchEngine, "Сливы");

        productBasket.clear();
    }
    private static void searchAndPrint(SearchEngine engine, String query) {
        System.out.println("Результат поиска по запросу: " + query);
        Searchable[] results = engine.search(query);
        System.out.println(Arrays.toString(results));
        System.out.println();
    }
}