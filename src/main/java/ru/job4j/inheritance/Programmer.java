package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private Technology[] listTechnology;

    public Programmer(String name, String surname, String education, String birthday, boolean officeWork, Technology[] listTechnology) {
        super(name, surname, education, birthday, officeWork);
        this.listTechnology = listTechnology;
    }

    public Project operation(Project project) {
        return project;
    }
}
