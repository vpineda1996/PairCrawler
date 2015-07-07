package me.vpineda.exceptions;

import java.io.IOException;

/**
 * Created by vpineda1996 on 2015-05-20.
 */
public class IllegalRequestException extends IOException {
    public IllegalRequestException() {
    }

    public IllegalRequestException(String message) {
        super(message);
    }
}
