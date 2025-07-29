package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;

public class SearchEngine {
    private final List<Searchable> items;

    public SearchEngine() {
        items = new ArrayList<>();
    }
    public void addItem(Searchable item) {
        items.add(item);
    }
    public List<Searchable> getItems() {
        return items;
    }
    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> resultMap = new TreeMap<>();
        for (Searchable item : items) {
            if (item.name().toLowerCase().contains(query.toLowerCase())) {
                resultMap.put(item.name(), item);
            }
        }
        return resultMap;
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
    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.isEmpty() || items.isEmpty()) {
            throw new BestResultNotFound(search);
        }
        String searchLower = search.toLowerCase();
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : items) {
            String term = item.getSearchTerm();
            if (term == null) continue;
            int count = countOccurrencesIgnoreCase(term, searchLower);
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
}
