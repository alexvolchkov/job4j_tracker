package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book book1 = new Book("Book 1", 100);
        Book book2 = new Book("Book 2", 200);
        Book book3 = new Book("Book 3", 300);
        Book book4 = new Book("Book 4", 400);
        book3.setName("Clean code");
        Book[] shelf = {book1, book2, book3, book4};
        for (int i = 0; i < shelf.length; i++) {
            System.out.println(shelf[i].getName());
        }
        Book tmp = shelf[0];
        shelf[0] = shelf[3];
        shelf[3] = tmp;
        for (Book book : shelf) {
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName());
            }
        }
    }
}
