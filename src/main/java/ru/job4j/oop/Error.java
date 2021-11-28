package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Активность: " + this.active);
        System.out.println("Статус: " + this.status);
        System.out.println("Сообщение: " + this.message);
    }

    public static void main(String[] args) {
        Error error1 = new Error(true, 2, "Error 1");
        error1.printInfo();
        System.out.println();
        Error error2 = new Error(false, 9, "Error 2");
        error2.printInfo();
        System.out.println();
        Error error3 = new Error(true, 1, "Error 3");
        error3.printInfo();
    }
}
