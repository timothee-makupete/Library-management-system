import java.io.*;
import java.util.ArrayList;

public class Library {
    String name;
    ArrayList<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

}