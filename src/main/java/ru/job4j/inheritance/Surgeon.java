package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private String specialization;

    public Surgeon(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public Surgeon(String name, String surname, String education, String birthday, String specialization) {
        super(name, surname, education, birthday);
        this.specialization = specialization;
    }

    public Surgeon(String name, String surname, String education, String birthday, Hospital hospital, String specialization) {
        super(name, surname, education, birthday, hospital);
        this.specialization = specialization;
    }

    public void operation(Pacient pacient) {

    }

}
