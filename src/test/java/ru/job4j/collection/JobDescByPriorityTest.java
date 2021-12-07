package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class JobDescByPriorityTest {

    @Test
    public void compare() {
        Job one = new Job("one", 1);
        Job two = new Job("two", 2);
        Job three = new Job("three", 3);
        Job four = new Job("four", 4);
        List<Job> jobs = Arrays.asList(one, two, three, four);
        jobs.sort(new JobDescByPriority());
        List<Job> expected = Arrays.asList(four, three, two, one);
        assertThat(jobs, is(expected));
    }
}