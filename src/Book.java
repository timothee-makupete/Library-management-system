public class Book {
    String author;
    String title;
    String isbn;
    int publicationYear;
    int availableCopies;
    int totalCopies;

    public Book(String author, String title, String isbn, int publicationYear, int totalCopies) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void decreaseAvailableCopies() {
        availableCopies--;
    }

    public void increaseAvailableCopies() {
        availableCopies++;
}
}