import java.util.ArrayList;
import java.util.List;

class Book {
    public String bookname;
    public String author;
    public String bookid;
    public int bookcount;

    public Book(String bookname, String author, String bookid, int bookcount) {
        this.bookname = bookname;
        this.author = author;
        this.bookid = bookid;
        this.bookcount = bookcount;
    }

    public String getbookname() {
        return bookname;
    }

    public String getid() {
        return bookid;
    }

    public int getbookcount() {
        return bookcount;
    }

    public void incrementbookcount(int count) {
        this.bookcount += count;
    }

    public boolean decrementbookcount() {
        if (bookcount > 0) {
            bookcount--;
            return true;
        }
        return false;
    }
}

class Reader {
    public String name;
    public String readerid;

    public Reader(String name, String readerid) {
        this.name = name;
        this.readerid = readerid;
    }

    public String getName() {
        return name;
    }

    public String getreaderid() {
        return readerid;
    }
}

class Liblary {
    public List<Book> Books;
    public List<Reader> Readers;

    public Liblary() {
        Books = new ArrayList<>();
        Readers = new ArrayList<>();
    }

    public void addBook(Book Book) {
        Books.add(Book);
        System.out.println("Add book = " + Book.getbookname());
    }

    public void removeBook(String bookid) {
        Books.removeIf(Book -> Book.getid().equals(bookid));
        System.out.println("Remove book = " + bookid);
    }

    public void registerReader(Reader Reader) {
        Readers.add(Reader);
        System.out.println("New reader = " + Reader.getName());
    }

    public void removeReader(String readerid) {
        Readers.removeIf(Reader -> Reader.getreaderid().equals(readerid));
        System.out.println("Remove reader = " + readerid);
    }

    public void lendBook(String bookid, String readerid) {
        for (Book Book : Books) {
            if (Book.getid().equals(bookid) && Book.decrementbookcount()) {
                System.out.println("Book " + Book.getbookname() + " to reader " + readerid);
                return;
            }
        }
        System.out.println("Book with id " + bookid + " not aviable");
    }

    public void returnBook(String bookid) {
        for (Book Book : Books) {
            if (Book.getid().equals(bookid)) {
                Book.incrementbookcount(1);
                System.out.println("Book = " + Book.getbookname() + " returned");
                return;
            }
        }
        System.out.println("Book with id " + bookid + " not found");
    }
}

public class Main {
    public static void main(String[] args) {
        Liblary Liblary = new Liblary();

        Book Book1 = new Book("Happy House", "John Cina", "1", 6);
        Book Book2 = new Book("MLBB", "Chou", "2", 2);

        Liblary.addBook(Book1);
        Liblary.addBook(Book2);

        Reader Reader1 = new Reader("Manat", "1");
        Reader Reader2 = new Reader("Murat", "2");

        Liblary.registerReader(Reader1);
        Liblary.registerReader(Reader2);

        Liblary.lendBook("1", "1");
        Liblary.lendBook("2", "2");

        Liblary.returnBook("1");
        Liblary.returnBook("2");

        Liblary.removeBook("2");
        Liblary.removeReader("2");
    }
}