package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HbmTrackerTest {

    @Test
    public void whenAdd() {
        Item item = new Item("Item");
        HbmTracker tracker = new HbmTracker();
        tracker.add(item);
        List<Item> items = tracker.findAll();
        assertEquals(item, items.get(0));
    }

    @Test
    public void whenReplace() {
        Item item = new Item("Item");
        HbmTracker tracker = new HbmTracker();
        tracker.add(item);
        Item item2 = new Item("Update");
        tracker.replace(item.getId(), item2);
        List<Item> items = tracker.findAll();
        assertEquals(item2.getName(), items.get(0).getName());
        assertEquals(item.getId(), items.get(0).getId());
    }

    @Test
    public void whenDelete() {
        Item item = new Item("Item");
        HbmTracker tracker = new HbmTracker();
        tracker.add(item);
        tracker.delete(item.getId());
        List<Item> items = tracker.findAll();
        assertEquals(0, items.size());
    }

    @Test
    public void whenFindAll() {
        Item item1 = new Item("Item1");
        Item item2 = new Item("Item2");
        HbmTracker tracker = new HbmTracker();
        tracker.add(item1);
        tracker.add(item2);
        List<Item> items = tracker.findAll();
        assertEquals(List.of(item1, item2), items);
    }

    @Test
    public void whenFindByName() {
        Item item1 = new Item("Item1");
        Item item2 = new Item("Item2");
        Item item3 = new Item("Item1");
        HbmTracker tracker = new HbmTracker();
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> items = tracker.findByName("Item1");
        assertEquals(List.of(item1, item3), items);
    }

    @Test
    public void findById() {
        Item item1 = new Item("Item1");
        Item item2 = new Item("Item2");
        HbmTracker tracker = new HbmTracker();
        tracker.add(item1);
        tracker.add(item2);
        Item itemDB = tracker.findById(item2.getId());
        assertEquals(item2, itemDB);
    }
}