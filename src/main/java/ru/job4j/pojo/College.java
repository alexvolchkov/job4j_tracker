package ru.job4j.pojo;

import java.util.Calendar;
import java.util.Date;

public class College {

    public static void main(String[] args) {
        Student petrov = new Student();
        petrov.setFio("Petrov Ivan Ivanovich");
        petrov.setGroup("21f");
        petrov.setDateAdmission(new Date(2021, Calendar.SEPTEMBER, 1));
        System.out.println("Студент: " + petrov.getFio());
        System.out.println("Группа: " + petrov.getGroup());
        System.out.println("Дата поступления: " + petrov.getDateAdmission());
    }
}
