package ru.job4j.inheritance;

public class Builder extends Engineer {

    private Building building;

    public Builder(String name, String surname, String education, String birthday, boolean officeWork, Building building) {
        super(name, surname, education, birthday, officeWork);
        this.building = building;
    }

    public void build(Building building) {

    }
}
