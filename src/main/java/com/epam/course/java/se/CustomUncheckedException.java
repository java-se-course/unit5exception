package com.epam.course.java.se;

public class CustomUncheckedException extends RuntimeException {
    public CustomUncheckedException() {
        super("Msg", null, true, true);
    }

    public CustomUncheckedException(String message) {
        super(message);
    }

    public CustomUncheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomUncheckedException(Throwable cause) {
        super(cause);
    }
}
