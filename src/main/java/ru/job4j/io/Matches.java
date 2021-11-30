package ru.job4j.io;

import java.util.Scanner;

public class Matches {

    public static int selectNumber(String player, Scanner input) {
        int matches;
        while (true) {
            System.out.println(player + " введите число от 1 до 3:");
            matches = Integer.parseInt(input.nextLine());
            if (matches >= 1 && matches <= 3) {
                break;
            }
        }
        return matches;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            turn = !turn;
            int matches = selectNumber(player, input);
            count -= matches;
            System.out.println("Осталось " + count + " спичек");
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}
