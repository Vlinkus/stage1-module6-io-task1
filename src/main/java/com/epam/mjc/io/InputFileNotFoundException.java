package com.epam.mjc.io;

import java.io.IOException;

public class InputFileNotFoundException extends RuntimeException{

    public InputFileNotFoundException(IOException message) {
        super(message);
    }
}
