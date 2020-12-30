import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import rateyourstuff.Book;
import rateyourstuff.ISBN13;
import rateyourstuff.InvalidISBNException;
import rateyourstuff.Person;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Robin Beck
 */

public class BookTest {
    @Test
    public void books_should_be_equal () {
        //Given

        ArrayList<String> publishers = new ArrayList<>();
        publishers.add("Rheinwerk Computing");

        ArrayList<Person> authors = new ArrayList<>();
        authors.add(new Person("Hans-Peter", "Habelitz"));

        ISBN13 isbn = null;
        try {
            isbn = new ISBN13("978-3-8362-4130-4");
        } catch (InvalidISBNException e) {
            e.printStackTrace();
        }

        ArrayList<String> languages = new ArrayList<>();
        languages.add("German");

        Book myBook =new Book("Programmieren Lernen mit Java",
                LocalDate.of(2016, 8, 23),
                "...",
                publishers,
                authors,
                isbn,
                languages,
                false,
                true,
                537);

        Book my2ndBook =new Book("Mehr Programmieren Lernen mit Java",
                LocalDate.of(2016, 9, 10),
                "...",
                publishers,
                authors,
                isbn,
                languages,
                false,
                true,
                537);

        //When
        boolean booksAreEqual = myBook.equals(my2ndBook);

        //Then
        assertTrue(booksAreEqual, "The Books are not equal");
    }

    @Test
    public void books_should_not_be_equal () {
        //Given

        ArrayList<String> publishers = new ArrayList<>();
        publishers.add("Rheinwerk Computing");

        ArrayList<Person> authors = new ArrayList<>();
        authors.add(new Person("Hans-Peter", "Habelitz"));

        ISBN13 isbn = null;
        try {
            isbn = new ISBN13("978-3-8362-4130-4");
        } catch (InvalidISBNException e) {
            e.printStackTrace();
        }

        ISBN13 isbn2ndBook = null;
        try {
            isbn2ndBook = new ISBN13("978-3-8362-7374-9");
        } catch (InvalidISBNException e) {
            e.printStackTrace();
        }

        ArrayList<String> languages = new ArrayList<>();
        languages.add("German");

        Book myBook =new Book("Programmieren Lernen mit Java",
                LocalDate.of(2016, 8, 23),
                "...",
                publishers,
                authors,
                isbn,
                languages,
                false,
                true,
                537);

        Book my2ndBook =new Book("Programmieren Lernen mit Java",
                LocalDate.of(2020, 4, 24),
                "...",
                publishers,
                authors,
                isbn2ndBook,
                languages,
                false,
                true,
                537);

        //When
        boolean booksAreEqual = myBook.equals(my2ndBook);

        //Then
        assertFalse(booksAreEqual, "The Books are equal");
    }
}
