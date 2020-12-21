import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import rateyourstuff.Library;
import rateyourstuff.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibraryTest {
    private static Library library;
    @BeforeAll
    public static void initialize_library () {
        library = new Library();
    }


    @Test
    public void should_add_book_to_library() {
        //Given
        String name = "Programmieren Lernen mit Java";
        LocalDate publicationDate = LocalDate.of(2016, 8, 23);
        String shortDescription = "Schritt für Schritt zum ersten Java Programm";

        ArrayList<String> publishers = new ArrayList<String>();
        publishers.add("Rheinwerk Computing");

        ArrayList<Person> authors = new ArrayList<Person>();
        authors.add(new Person("Hans-Peter", "Habelitz"));

        String isbn = "978-3-8362-4130-4";

        ArrayList<String> languages = new ArrayList<String>();
        languages.add("German");
        boolean isEBook = false;
        boolean isPrint = true;
        int numberOfPages = 537;
        //When
        boolean bookHasBeenInserted;
        bookHasBeenInserted = library.addNewBook(name,
        publicationDate,
        shortDescription,
        publishers,
        authors,
        isbn,
        languages,
        isEBook,
        isPrint,
        numberOfPages);

        //Then
        assertTrue(bookHasBeenInserted, "The Creation of a new book was not successful!");
    }

    @Test
    public void should_not_add_book_to_library() {
        //Given
        String name = "";
        LocalDate publicationDate = LocalDate.of(2016, 8, 23);
        String shortDescription = "Schritt für Schritt zum ersten Java Programm";

        ArrayList<String> publishers = new ArrayList<String>();
        publishers.add("Rheinwerk Computing");

        ArrayList<Person> authors = new ArrayList<Person>();
        authors.add(new Person("Hans-Peter", "Habelitz"));

        String isbn = "978-3-8362-4130-4";

        ArrayList<String> languages = new ArrayList<String>();
        languages.add("German");
        boolean isEBook = false;
        boolean isPrint = true;
        int numberOfPages = 20;
        //When
        boolean bookHasBeenInserted;
        bookHasBeenInserted = library.addNewBook(name,
                publicationDate,
                shortDescription,
                publishers,
                authors,
                isbn,
                languages,
                isEBook,
                isPrint,
                numberOfPages);

        //Then
        assertFalse(bookHasBeenInserted, "The Creation of a new book was successful!");
    }


}
