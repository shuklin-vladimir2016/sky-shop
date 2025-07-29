package org.skypro.skyshop.exceptions;

import org.skypro.skyshop.search.Searchable;

public class MySearchable implements Searchable {
    private final String name;

    public MySearchable(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Searchable {" + "name = '" + name + '\'' + '}';
    }

    @Override
    public String name() {
        return "";
    }

    @Override
    public String getSearchTerm() {
        return "";
    }
}
