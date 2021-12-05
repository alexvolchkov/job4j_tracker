package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("volkaa@mail.ru", "Aleksandr Volchkov");
        for (String s : map.keySet()) {
            System.out.println(s + " = " + map.get(s));
        }
    }

}
