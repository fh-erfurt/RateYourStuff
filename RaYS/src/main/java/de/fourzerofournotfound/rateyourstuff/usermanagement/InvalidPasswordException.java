package de.fourzerofournotfound.rateyourstuff.usermanagement;

/**
 *
 * Invalid Password Exception
 * <p>This class is used to throw an exception, if the login of an user failed</p>
 * @author Robin Beck, Christoph Frischmuth, Mickey Knop, John Klippstein
 *
 * */
public class InvalidPasswordException extends Exception{
    InvalidPasswordException(){
        super();
    }

    InvalidPasswordException(String msg){
        super(msg);
    }

}
