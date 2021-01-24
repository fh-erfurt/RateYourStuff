package de.fourzerofournotfound.rateyourstuff.mediamanagament.mediatypes.books.isbn;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.books.isbn.ISBN10;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.books.isbn.InvalidISBNException;

/**
 * @author Robin Beck, Christoph Frischmuth, Mickey Knop, John Klippstein
 */

public class ISBN10Test {

    @Test
    public void should_be_valid_isbn10() {
        //Given
        String isbnString = "3-492-23674-X";

        // When
        boolean isValidISBN10 = ISBN10.isValid(isbnString);

        //Then
        assertTrue(isValidISBN10, "The given Variable is not a valid ISBN10");
    }

    @Test
    public void should_be_invalid_isbn10() {
        //Given
        String isbnString = "197-3-492-23674-X";

        // When
        boolean isValidISBN10 = ISBN10.isValid(isbnString);

        //Then
        assertFalse(isValidISBN10, "The given Variable is a valid ISBN10");
    }

    @Test
    public void should_create_a_valid_ISBN10_object() {
        //Given
        String isbnString = "3-492-23674-X";

        //When
        ISBN10 isbn10 = null;

        try {
            isbn10 = new ISBN10(isbnString);
        } catch (InvalidISBNException e) {
            e.printStackTrace();
        }

        assertEquals(isbnString, isbn10.toString(), "The isbn string does not match");
    }
}
