package ru.job4j.oop;

public class JukeBox {

    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        } else if (position == 2) {
            System.out.println("Спят усталые игрушки, книжки спят.");
        } else {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        JukeBox juke = new JukeBox();
        juke.music(1);
        juke.music(2);
        juke.music(3);
    }
}
