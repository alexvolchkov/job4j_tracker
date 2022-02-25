package ru.job4j.gc.cache;

import ru.job4j.tracker.*;

public class Emulator {

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        output.println("Укажите директорию хранения файлов");
        AbstractCache<String, String> cache = new DirFileCache(input.askStr("Select:"));
        boolean run = true;
        while (run) {
            output.println("Укажите имя файла");
            output.println(cache.get(input.askStr("Select:")));
        }
    }
}
