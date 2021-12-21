package ru.job4j.stream;

import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(sut -> Stream.of(Value.values())
                        .map(val -> sut.toString() + " " + val.toString()))
                        .forEach(System.out::println);
    }
}
