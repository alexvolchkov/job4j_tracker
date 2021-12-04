package ru.job4j.search;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phone = new PhoneDictionary();
        phone.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        ArrayList<Person> persons = phone.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }
}