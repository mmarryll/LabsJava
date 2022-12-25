import java.util.*;

public class Books {

    public static class SortByAuthor implements Comparator<Book> {
        public int compare(Book b1, Book b2) {
        return b1.author.compareTo(b2.author);
        }
    }
    public static class Book implements Comparable<Book>{
        private String name;
        private String author;

        public Book(String name_, String author_){
            name = name_;
            author = author_;
        }

        public int compareTo(Book other){
            return name.compareTo(other.name);
        }

        public String ToString(){
            return name + " " + author;
        }

    }

    public static void main(String[] args){
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("War and Piece", "Tolstoy"));
        books.add(new Book("Mumu", "Turgenev"));
        books.add( new Book("Carry","King"));
        for (Book book : books) {
            System.out.println(book.ToString());
        }
        SortByAuthor byaut = new SortByAuthor();
        books.sort(byaut);
        System.out.println("Sorted by author: ");
        for (Book book : books) {
            System.out.println(book.ToString());
        }
        System.out.println("Sorted by name: ");
        Collections.sort(books);
        for (Book book : books) {
            System.out.println(book.ToString());
        }
        Book book = new Book("War and Piece", "Tolstoy");
        int finder = Collections.binarySearch(books, book);
        System.out.println(finder);
    }
}