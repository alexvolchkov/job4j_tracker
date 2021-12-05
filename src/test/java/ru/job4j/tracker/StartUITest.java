package ru.job4j.tracker;

import org.junit.Test;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
    private final Output output = new ConsoleOutput();

    @Test
    public void whenCreateItem() {
        List<String> answers = new ArrayList<>();
        answers.add("0");
        answers.add("Item name");
        answers.add("1");
        Input in = new StubInput(answers);
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(output));
        actions.add(new ExitAction());
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenEditItem() {
        Tracker tracker = new Tracker();
        Item itemOne = tracker.add(new Item("Item one"));
        List<String> answers = new ArrayList<>();
        answers.add("0");
        answers.add(String.valueOf(itemOne.getId()));
        answers.add("Item two");
        answers.add("1");
        Input input = new StubInput(answers);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new EditAction(output));
        actions.add(new ExitAction());
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item two"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item itemOne = tracker.add(new Item("Item one"));
        List<String> answers = new ArrayList<>();
        answers.add("0");
        answers.add(String.valueOf(itemOne.getId()));
        answers.add("1");
        Input input = new StubInput(answers);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(output));
        actions.add(new ExitAction());
        new StartUI(output).init(input, tracker, actions);
        assertNull(tracker.findById(itemOne.getId()));
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        List<String> answers = new ArrayList<>();
        answers.add("0");
        answers.add(String.valueOf(one.getId()));
        answers.add(replaceName);
        answers.add("1");
        Input in = new StubInput(answers);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new EditAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenShowAllItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        List<String> answers = new ArrayList<>();
        answers.add("0");
        answers.add("1");
        Input in = new StubInput(answers);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenFindByIdItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        List<String> answers = new ArrayList<>();
        answers.add("0");
        answers.add(String.valueOf(one.getId()));
        answers.add("1");
        Input in = new StubInput(answers);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIdAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenFindByNameItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        List<String> answers = new ArrayList<>();
        answers.add("0");
        answers.add(one.getName());
        answers.add("1");
        Input in = new StubInput(answers);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Find items by name ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        List<String> answers = new ArrayList<>();
        answers.add("7");
        answers.add("0");
        Input in = new StubInput(answers);
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu:" + ln
                        + "0. Exit Program" + ln
                )
        );
    }
}