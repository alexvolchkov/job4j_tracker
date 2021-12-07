package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        for (int i = 0; i < left.length() && i < right.length() && rsl == 0; i++) {
            rsl = Character.compare(left.charAt(i), right.charAt(i));
        }
        if (rsl == 0 && left.length() != right.length()) {
            rsl = left.length() > right.length() ? 1 : -1;
        }
        return rsl;
    }
}
