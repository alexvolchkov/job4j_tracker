package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {
    public static HashSet<String> extractNumber(List<Task> list) {
        HashSet<String> number = new HashSet<>();
        for (Task task : list) {
            number.add(task.getNumber());
        }
        return number;
    }
}
