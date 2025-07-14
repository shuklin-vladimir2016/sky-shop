package org.skypro.skyshop.articles;

import org.skypro.skyshop.exceptions.Searchable;

public class Article implements Searchable {
    private final String title;

    public Article(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Название: " + title;
    }

    @Override
    public String getSearchTerm() {
        return title;
    }
}
