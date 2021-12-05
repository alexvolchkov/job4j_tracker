package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        List<String> answers = new ArrayList<>();
        answers.add("one");
        answers.add("1");
        Input in = new StubInput(answers);
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        List<String> answers = new ArrayList<>();
        answers.add("1");
        Input in = new StubInput(answers);
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenMultipleValidInput() {
        Output out = new StubOutput();
        List<String> answers = new ArrayList<>();
        answers.add("1");
        answers.add("2");
        answers.add("3");
        Input in = new StubInput(answers);
        ValidateInput input = new ValidateInput(out, in);
        int[] selected = {
                input.askInt("Enter menu:"),
                input.askInt("Enter menu:"),
                input.askInt("Enter menu:")
        };
        assertThat(selected, is(new int[]{1, 2, 3}));
    }

    @Test
    public void whenValidNegativeInput() {
        Output out = new StubOutput();
        List<String> answers = new ArrayList<>();
        answers.add("-2");
        Input in = new StubInput(answers);
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-2));
    }
}