package rateyourstuff;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ISBN10 {
    public static final int    ISBN_10_LENGTH = 10;

    private String isbn;

    public ISBN10(String isbn10) throws InvalidISBNException {
        if (isValid(isbn10)) {
            this.isbn = isbn10;
        } else {
            throw new InvalidISBNException(isbn10 + "is invalid");
        }
    }

    //returns true if given isbn13 is valid
    public static boolean isValid (String isbn10) {
        return (isValidFormat(isbn10) && hasValidChecksum(isbn10));
    }

    //returns true if format of the isbn is valid (ignores checksum-correctness)
    public static boolean isValidFormat (String isbn10) {
        //RegEx pattern to determine structure of ISBN
        Pattern isbnPattern = Pattern.compile("\\b\\d{1,5}-\\d{2,7}-\\d{2,7}-(\\d|X)\\b");
        Matcher isbnMatcher = isbnPattern.matcher(isbn10);

        //get isbn length without special delimiters
        int isbnLength = isbn10.replace("-", "").length();
        return ((isbnLength == ISBN_10_LENGTH) && isbnMatcher.matches());
    }

    //returns true if the given isbn has a valid checksum
    static boolean hasValidChecksum(String isbn10) {
        //Extract the checksum of the given ISBN
        char placedCheckSum = extractChecksum(isbn10);
        //Calculate the checksum of the given ISBN
        char actualCheckSum = calculateChecksum(isbn10);

        return placedCheckSum == actualCheckSum;
    }

    //returns the checksum of a given isbn
    public static char extractChecksum(String isbn10) {
        return isbn10.charAt(isbn10.length()-1);
    }

    //returns the correct checksum, receives complete isbn
    public static char calculateChecksum(String isbn10) {
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

    public String toString() {
        return isbn;
    }
}