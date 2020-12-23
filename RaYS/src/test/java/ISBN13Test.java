import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import rateyourstuff.ISBN10;
import rateyourstuff.ISBN13;
import rateyourstuff.InvalidISBNException;

/**
 * @author Robin Beck
 */

public class ISBN13Test {

    @Test
    public void should_be_valid_isbn13 () {
        //Given
        String isbnString = "978-3-8362-4130-4";

        //When
        boolean isValidISBN13 = ISBN13.isValid(isbnString);

        //Then
        assertTrue(isValidISBN13, "The given ISBN13 is not correct");
    }

    @Test
    public void should_be_invalid_isbn13() {
        //Given
        String isbnString = "3-492-23674-X";

        //When
        boolean isValidISBN13 = ISBN13.isValid(isbnString);

        //Then
        assertFalse(isValidISBN13, "The given ISBN13 is correct");
    }

    @Test
    public void should_transform_isbn10_to_isbn13() {
        //Given
        ISBN10 isbn10 = null;
        try {
            isbn10 = new ISBN10("3-492-23674-X");
        } catch (InvalidISBNException e) {
            e.printStackTrace();
        }
        String actualISBN13String = "978-3-492-23674-4";

        //When
        String isbn13String = null;
        try {
            isbn13String = (ISBN13.toISBN13(isbn10)).toString();
        } catch (InvalidISBNException e) {
            e.printStackTrace();
        }

        //Then
        assertEquals(actualISBN13String, isbn13String, "The isbn was not converted correctly");
    }


}
