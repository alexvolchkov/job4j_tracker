package ru.job4j.pojo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class College {

    public static void main(String[] args) {
        Student petrov = new Student();
        petrov.setFio("Petrov Ivan Ivanovich");
        petrov.setGroup("21f");
        petrov.setDateAdmission(new GregorianCalendar(2021, Calendar.SEPTEMBER, 1));
        System.out.println("Студент: " + petrov.getFio());
        System.out.println("Группа: " + petrov.getGroup());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println("Дата поступления: " + dateFormat.format(petrov.getDateAdmission().getTime()));
    }
}
