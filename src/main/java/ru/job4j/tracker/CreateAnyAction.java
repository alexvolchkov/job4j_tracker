package ru.job4j.tracker;

public class CreateAnyAction implements UserAction {

    private final Output out;

    public CreateAnyAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add any new Items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Create any new Items ===");
        int num = input.askInt("Введите количество: ");
        for (int i = 1; i <= num; i++) {
            String name = String.format("Item%d", i);
            tracker.add(new Item(name));
        }
        out.println(String.format("Добавлено %d заявок", num));
        return true;
    }
}
