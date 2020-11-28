package rateyourstuff;
/*
 *
 * Author: Robin Beck
 *
 * */

public class InvalidISBNException extends Exception{
    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    InvalidISBNException() {
    }

    InvalidISBNException(String exceptionMessage) {
        super(exceptionMessage);
    }
    //endregion
}