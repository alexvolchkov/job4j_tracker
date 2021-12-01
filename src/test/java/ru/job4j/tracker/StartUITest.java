package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class StartUITest {

    private final Output output = new ConsoleOutput();

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenEditItem() {
        Input input = new StubInput(
                new String[] {"0", "Item one", "1", "1", "Item two", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
          new CreateAction(output),
          new EditAction(output),
          new ExitAction()
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item two"));
    }

    @Test
    public void whenDeleteItem() {
        Input input = new StubInput(
                new String[] {"0", "Item one", "1", "1", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new DeleteAction(output),
                new ExitAction()
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(1), is(nullValue()));
    }
}