package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class JobDescByNameTest {

    @Test
    public void compare() {
        Job one = new Job("one", 1);
        Job two = new Job("two", 2);
        Job three = new Job("three", 3);
        Job four = new Job("four", 4);
        List<Job> jobs = Arrays.asList(one, two, three, four);
        jobs.sort(new JobDescByName());
        List<Job> expected = Arrays.asList(two, three, one, four);
        assertThat(jobs, is(expected));
    }
}