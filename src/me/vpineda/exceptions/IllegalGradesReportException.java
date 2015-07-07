package me.vpineda.exceptions;

import java.io.IOException;

/**
 * Created by vpineda1996 on 2015-06-01.
 */
public class IllegalGradesReportException extends IOException{

    public IllegalGradesReportException() {
    }

    public IllegalGradesReportException(String message) {
        super(message);
    }
}
