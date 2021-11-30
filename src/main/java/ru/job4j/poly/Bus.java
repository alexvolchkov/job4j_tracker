package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passengers(int number) {
        System.out.println("Количество пассажиров");
    }

    @Override
    public double refuel(double quantity) {
        return quantity * 50;
    }
}
