package ru.job4j.inheritance;

public class Dentist extends Doctor {

    public Dentist(String name, String surname, String education, String birthday, Hospital hospital) {
        super(name, surname, education, birthday, hospital);
    }

    public void healTooth(Pacient pacient) {

    }
}
