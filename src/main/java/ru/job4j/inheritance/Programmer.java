package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private Technology[] listTechnology;

    public Programmer(String name, String surname, String education, String birthday, Technology[] listTechnology) {
        super(name, surname, education, birthday);
        this.listTechnology = listTechnology;
    }

    public Programmer(String name, String surname, String education, String birthday, boolean officeWork, Technology[] listTechnology) {
        super(name, surname, education, birthday, officeWork);
        this.listTechnology = listTechnology;
    }

    public Programmer(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public Project operation(Project project) {
        return project;
    }
}
