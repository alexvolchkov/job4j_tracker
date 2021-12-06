package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemDescByNameTest {

    @Test
    public void compare() {
        Item itemOne = new Item("item one");
        Item itemTwo = new Item("item two");
        Item itemThree = new Item("item three");
        Item itemFour = new Item("item four");
        List<Item> items = new ArrayList<>();
        items.add(itemOne);
        items.add(itemTwo);
        items.add(itemThree);
        items.add(itemFour);
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = new ArrayList<>();
        expected.add(itemTwo);
        expected.add(itemThree);
        expected.add(itemOne);
        expected.add(itemFour);
        assertThat(items, is(expected));
    }
}