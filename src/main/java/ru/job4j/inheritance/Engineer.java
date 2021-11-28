package ru.job4j.inheritance;

public class Engineer extends Profession {

    private boolean officeWork;

    public Engineer(String name, String surname, String education, String birthday, boolean officeWork) {
        super(name, surname, education, birthday);
        this.officeWork = officeWork;
    }

    public void projectAnalysis(Project project) {

    }
}
