import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import rateyourstuff.ISBN10;
import rateyourstuff.InvalidISBNException;

public class ISBN10Test {

    @Test
    public void should_be_valid_isbn10() {
        //Given
        String isbnString = "3-492-23674-X";

        // When
        boolean isValidISBN10 = ISBN10.isValid(isbnString);

        //Then
        assertEquals(true, isValidISBN10, "The given Variable is not a valid ISBN10");
    }

    @Test
    public void should_be_invalid_isbn10() {
        //Given
        String isbnString = "197-3-492-23674-X";

        // When
        boolean isValidISBN10 = ISBN10.isValid(isbnString);

        //Then
        assertEquals(false, isValidISBN10, "The given Variable is a valid ISBN10");
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
