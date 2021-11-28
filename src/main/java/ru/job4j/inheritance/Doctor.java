package ru.job4j.inheritance;

public class Doctor extends Profession {

    private Hospital hospital;

    public Doctor(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public Doctor(String name, String surname, String education, String birthday, Hospital hospital) {
        super(name, surname, education, birthday);
        this.hospital = hospital;
    }

    public Diagnosis heal(Pacient pacient) {
        return new Diagnosis();
    }
}
