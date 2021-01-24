package de.fourzerofournotfound.rateyourstuff.mediamanagament.mediatypes.books;

import de.fourzerofournotfound.rateyourstuff.mediamanagement.Genre;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.books.Book;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.books.isbn.ISBN13;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.books.isbn.InvalidISBNException;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.persons.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Robin Beck, Christoph Frischmuth, Mickey Knop, John Klippstein
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
                Genre.EDUCATION,
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
                Genre.EDUCATION,
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
                Genre.EDUCATION,
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
                Genre.EDUCATION,
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
