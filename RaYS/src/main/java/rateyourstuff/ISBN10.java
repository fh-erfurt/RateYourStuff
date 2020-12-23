package rateyourstuff;
/**
 *
 * @author Robin Beck
 *
 * */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ISBN10 {

    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    public static final int    ISBN_10_LENGTH = 10;

    private String isbn;
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    public ISBN10(String isbn10) throws InvalidISBNException {
        if (isValid(isbn10)) {
            this.isbn = isbn10;
        } else {
            throw new InvalidISBNException(isbn10 + "is invalid");
        }
    }
    //endregion

    //region Methods
    ////////////////////////////////////////////////////////////////////////////////////

    //returns true if given isbn10 is valid
    public static boolean isValid (String isbn10) {
        return (hasValidFormat(isbn10) && hasValidChecksum(isbn10));
    }

    //returns true if format of the isbn is valid (ignores checksum-correctness)
    private static boolean hasValidFormat (String isbn10) {
        //RegEx pattern to determine structure of ISBN
        Pattern isbnPattern = Pattern.compile("\\b\\d{1,5}-\\d{2,7}-\\d{2,7}-(\\d|X)\\b");
        Matcher isbnMatcher = isbnPattern.matcher(isbn10);

        //get isbn length without special delimiters
        int isbnLength = isbn10.replace("-", "").length();
        return ((isbnLength == ISBN_10_LENGTH) && isbnMatcher.matches());
    }

    //returns true if the given isbn has a valid checksum
    private static boolean hasValidChecksum(String isbn10) {
        //Extract the checksum of the given ISBN
        char placedCheckSum = extractChecksum(isbn10);
        //Calculate the checksum of the given ISBN
        char actualCheckSum = calculateChecksum(isbn10);

        return placedCheckSum == actualCheckSum;
    }

    //returns the checksum of a given isbn
    private static char extractChecksum(String isbn10) {
        return isbn10.charAt(isbn10.length()-1);
    }

    //returns the correct checksum, receives complete isbn
    private static char calculateChecksum(String isbn10) {
        String mainISBN = isbn10;
        mainISBN = mainISBN.substring(0, mainISBN.length()-1).replace("-", "");

        int isbnSum = 0;
        int checkSum = 0;
        char checkSumChar;
        for(int i = 0; i < mainISBN.length(); i++) {
            int currentValue = Integer.parseInt(String.valueOf(mainISBN.charAt(i)));
            isbnSum += (i + 1) * currentValue;
        }

        int result = isbnSum % 11;

        if(result == 10) {
            checkSumChar = 'X';
        } else {
            checkSumChar = (char) (result + '0');
        }
        return  checkSumChar;
    }

    @Override
    public String toString() {
        return isbn;
    }
    //endregion
}