package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final List<Searchable> items = new ArrayList<>();
    private final SearchableComparator comparator = new SearchableComparator();

    public void addItem(Searchable item) {
        if (item != null) {
            items.add(item);
        }
    }
    public List<Searchable> getItems() {
        return items;
    }
    public Set<Searchable> search(String query) {
        if (query == null || query.isEmpty()) {
            return new TreeSet<>(comparator);
        }
        String queryLower = query.toLowerCase();

        return items.stream()
                .filter(item -> item.getName() != null && item.getName().toLowerCase().contains(queryLower))
                .collect(Collectors.toCollection(() -> new TreeSet<>(comparator)));
    }
    public Searchable findBestMatch(String search, List<? extends Searchable> items) throws BestResultNotFound {
        if (search == null || search.isEmpty() || items == null || items.isEmpty()) {
            throw new BestResultNotFound(search);
        }
        String searchLower = search.toLowerCase();
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : items) {
            String term = item.getSearchTerm();
            if (term == null) {
                continue;
            }
            int count = countOccurrencesIgnoreCase(term.toLowerCase(), searchLower);
            if (count > maxCount) {
                maxCount = count;
                bestMatch = item;
            }
        }

        if (bestMatch == null || maxCount == 0) {
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
    public class SearchableComparator implements Comparator<Searchable> {

        @Override
        public int compare(Searchable o1, Searchable o2) {
            if (o1 == o2) {
                return 0;
            }
            if (o1 == null || o2 == null) {
                if (o1 == null && o2 == null) {
                    return 0;
                }
                if (o1 == null) {
                    return -1;
                }
                return 1;
            }
            String name1 = o1.getName();
            String name2 = o2.getName();

            if (name1 == null || name2 == null) {
                if (name1 == null && name2 == null) {
                    return 0;
                }
                if (name1 == null) {
                    return -1;
                }
                return 1;
            }
            return name1.compareTo(name2);
        }
    }
}
