package me.vpineda.exceptions;

/**
 * Created by vpineda1996 on 2015-09-06.
 */
public class InvalidServerResponseException extends Exception{

    public InvalidServerResponseException(String message) {
        super(message);
    }

    public InvalidServerResponseException(String message, Throwable cause) {
        super(message, cause);
    }
}
