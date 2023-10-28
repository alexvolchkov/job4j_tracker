package ru.job4j.tracker;

import ru.job4j.react.Observe;

import java.util.List;

public interface Store {
    Item add(Item item);

    boolean replace(int id, Item item);

    void delete(int id);

    List<Item> findAll();

    default void findAll(Observe<Item> observe) {

    }

    List<Item> findByName(String key);

    Item findById(int id);
}
