package org.skypro.skyshop.search;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable a1, Searchable a2) {
        int lengthCompare = Integer.compare(a1.getName().length(), a2.getName().length());
        if (lengthCompare != 0) {
            return lengthCompare;
        }
        return a1.getName().compareTo(a2.getName());
    }
}
