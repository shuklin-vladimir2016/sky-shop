package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;

public class SearchEngine {
    private Set<Searchable> items = new TreeSet<>(new SearchableComparator());

    public void addItem(Searchable item) {
        items.add(item);
    }

    public Searchable findBestMatch(String search, Set<? extends Searchable> items) throws BestResultNotFound {
        if (search == null || search.isEmpty() || items.isEmpty()) {
            throw new BestResultNotFound(search);
        }
        String searchLower = search.toLowerCase();
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : items) {
            String term = item.getSearchTerm();
            if (term == null) continue;
            int count = countOccurrencesIgnoreCase(term.toLowerCase(), searchLower);
            if (count > maxCount) {
                maxCount = count;
                bestMatch = item;
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFound(search);
        }
        return bestMatch;
    }

    private int countOccurrencesIgnoreCase(String text, String subLower) {
        if (text == null || subLower == null || subLower.isEmpty()) {
            return 0;
        }
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(subLower, index)) != -1) {
            count++;
            index += subLower.length();
        }
        return count;
    }

    public Set<Searchable> search(String query) {
        Set<Searchable> found = new TreeSet<>(new SearchableComparator());
        String queryLower = query.toLowerCase();

        for (Searchable item : items) {
            if (item.getName().toLowerCase().contains(queryLower)) {
                found.add(item);
            }
        }
        return found;
    }

    public Set<Searchable> getItems() {
        return items;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Список товаров: \n");
        for (Searchable item : items) {
            sb.append(item.getName()).append("\n");
        }
        return sb.toString();
    }
}


