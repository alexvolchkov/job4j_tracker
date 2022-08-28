package ru.job4j.react;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var store = new Store();
        store.getByReact(System.out::println);
    }
}
