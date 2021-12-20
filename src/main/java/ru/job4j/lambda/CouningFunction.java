package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class CouningFunction {

    public static List<Double> diapason(int start, int end, Function<Double, Double> funct) {
        List<Double> rsl = new ArrayList<>();
        Consumer<Double> consumer = rsl::add;
        for (int i = start; i < end; i++) {
            rsl.add(funct.apply((double) i));
        }
        return rsl;
    }
}
