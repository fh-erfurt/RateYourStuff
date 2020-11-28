package rateyourstuff;

public class InvalidISBNException extends Exception{
    InvalidISBNException() {
    }

    InvalidISBNException(String exceptionMessage) {
        super(exceptionMessage);
    }
}