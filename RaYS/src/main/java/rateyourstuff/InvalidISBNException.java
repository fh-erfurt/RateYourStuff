package rateyourstuff;
/**
 * <h1>Invalid ISBN Exception</h1>
 * <p>This class is used to throw an exception, if an ISBN is not valid</p>
 * @author Robin Beck
 *
 * */

public class InvalidISBNException extends Exception{
    InvalidISBNException() {
    }

    InvalidISBNException(String exceptionMessage) {
        super(exceptionMessage);
    }
}