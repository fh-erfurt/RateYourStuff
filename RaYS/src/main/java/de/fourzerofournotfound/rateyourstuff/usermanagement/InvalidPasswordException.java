package de.fourzerofournotfound.rateyourstuff.usermanagement;

public class InvalidPasswordException extends Exception{
    InvalidPasswordException(){
        super();
    }

    InvalidPasswordException(String msg){
        super(msg);
    }

}
