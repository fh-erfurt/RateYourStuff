package rateyourstuff;
/**
 * <h1>ISBN13</h1>
 * <p>This class represents the ISBN13 and contains methods to validate isbn13 und transform isbn10 to isbn13</p>
 * @author Robin Beck
 *
 * */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ISBN13 {
    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    public static final String ISBN_13_PREFIX = "978-";
    public static final int    ISBN_13_LENGTH = 13;

    private String isbn;
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////

    /**
     * Used to create a new isbn13 from a valid isbn13 string
     * @param isbn13 isbn13 string, separated with "-"
     * @throws InvalidISBNException, if the given isbn13 is not valid
     */
    public ISBN13(String isbn13) throws InvalidISBNException {
        if (isValid(isbn13)) {
            this.isbn = isbn13;
        } else {
            throw new InvalidISBNException(isbn13 + "is invalid");
        }
    }
    //endregion

    //region Methods
    ////////////////////////////////////////////////////////////////////////////////////

    //returns true if given isbn13 is valid
    public static boolean isValid (String isbn13) {
        return (hasValidFormat(isbn13) && hasValidChecksum(isbn13));
    }

    //returns true if format of the isbn is valid (ignores checksum-correctness)
    public static boolean hasValidFormat (String isbn13) {
        //RegEx pattern to determine structure of ISBN
        Pattern isbnPattern = Pattern.compile("\\b978-\\d{1,5}-\\d{2,7}-\\d{2,7}-\\d\\b");
        Matcher isbnMatcher = isbnPattern.matcher(isbn13);

        //get isbn length without special delimiters
        int isbnLength = isbn13.replace("-", "").length();
        return ((isbnLength == ISBN_13_LENGTH) && isbnMatcher.matches());
    }

    //returns true if the given isbn has a valid checksum
    private static boolean hasValidChecksum(String isbn13) {
        //Extract the checksum of the given ISBN
        char placedCheckSum = extractChecksum(isbn13);
        //Calculate the checksum of the given ISBN
        char actualCheckSum = calculateChecksum(isbn13);

        return placedCheckSum == actualCheckSum;
    }

    //returns the checksum of a given isbn
    private static char extractChecksum(String isbn13) {
        return isbn13.charAt(isbn13.length()-1);
    }

    /**
     * This function calculates the correct checksum for a given isbn13 string
     * @param isbn complete isbn13 string (including the current or a false checksum)
     * @return the correct checksum
     */
    private static char calculateChecksum(String isbn) {
        String mainISBN = isbn;
        mainISBN = mainISBN.substring(0, mainISBN.length()-1).replace("-", "");

        int isbnSum = 0;
        int checkSum;
        for(int i = 0; i < mainISBN.length(); i++) {
            int currentValue = Integer.parseInt(String.valueOf(mainISBN.charAt(i)));
            isbnSum += ((i+1) % 2 == 0) ? 3 * currentValue : currentValue;
        }

        checkSum = 10 - (isbnSum % 10);
        if(checkSum == 10) {
            checkSum = 0;
        }
        return (char) (checkSum + '0');
    }

    /**
     * converts an ISBN10 object to an ISBN13 object
     * @param isbn10 valid isbn10 object
     * @return isbn13 object
     * @throws InvalidISBNException, if it is not possible to create the isbn13 object
     */
    public static ISBN13 toISBN13(ISBN10 isbn10) throws InvalidISBNException {
        String isbn13;
        String isbn10String = isbn10.toString();

        isbn13 = ISBN_13_PREFIX + isbn10String;
        char isbn13CheckSum = calculateChecksum(isbn13);
        isbn13 = isbn13.substring(0, isbn13.length()-1) + isbn13CheckSum;
        return new ISBN13(isbn13);
    }

    public String toString() {
        return isbn;
    }
    //endregion
}
