package ru.job4j.collection;

import java.util.Comparator;
import java.util.List;
import java.util.logging.StreamHandler;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1Split = o1.split("/");
        String[] o2Split = o2.split("/");
        for (int i = 0; i < Math.min(o1Split.length, o2Split.length); i++) {
            int rsl = 0;
            if (i == 0) {
                rsl = o2Split[i].compareTo(o1Split[i]);
            } else {
                rsl = o1Split[i].compareTo(o2Split[i]);
            }
            if (rsl != 0) {
                return rsl;
            }
        }
        return Integer.compare(o1Split.length, o2Split.length);
    }
}
