package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class SearchFolder {

    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        List<Folder> rsl = new ArrayList<>();
        Consumer<Folder> con = folder -> rsl.add(folder);
        for (Folder folder : list) {
            if (pred.test(folder)) {
                con.accept(folder);
            }
        }
        return rsl;
    }
}
