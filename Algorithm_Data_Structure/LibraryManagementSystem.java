class Book {
    int bookId;
    String title;
    String author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
}

public class LibraryManagementSystem {

    public static void linearSearch(Book[] books, String title) {

        for (int i = 0; i < books.length; i++) {

            if (books[i].title.equalsIgnoreCase(title)) {

                System.out.println("Book Found");
                System.out.println(
                        books[i].bookId + " "
                        + books[i].title + " "
                        + books[i].author
                );

                return;
            }
        }

        System.out.println("Book Not Found");
    }

    public static void binarySearch(Book[] books, String title) {

        int low = 0;
        int high = books.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result = books[mid].title.compareToIgnoreCase(title);

            if (result == 0) {

                System.out.println("Book Found");
                System.out.println(
                        books[mid].bookId + " "
                        + books[mid].title + " "
                        + books[mid].author
                );

                return;
            }

            if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Book Not Found");
    }

    public static void main(String[] args) {

        Book[] books = {
                new Book(101, "C Programming", "Dennis"),
                new Book(102, "Data Structures", "Mark"),
                new Book(103, "Java", "James"),
                new Book(104, "Python", "Guido"),
                new Book(105, "SQL", "John")
        };

        System.out.println("Linear Search:");
        linearSearch(books, "Java");

        System.out.println();

        System.out.println("Binary Search:");
        binarySearch(books, "Java");
    }
}