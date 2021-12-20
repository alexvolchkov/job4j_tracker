package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int total = 0;
        for (int num : number) {
            total = add(total, () -> num);
        }
        System.out.println(total);
    }

    private static Integer add(int sum, Supplier<Integer> calc) {
        return calc.get() + sum;
    }
}
