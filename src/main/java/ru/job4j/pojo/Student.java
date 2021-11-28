package ru.job4j.pojo;

import java.util.GregorianCalendar;

public class Student {

    private String fio;
    private String group;
    private GregorianCalendar dateAdmission;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public GregorianCalendar getDateAdmission() {
        return dateAdmission;
    }

    public void setDateAdmission(GregorianCalendar dateAdmission) {
        this.dateAdmission = dateAdmission;
    }
}
