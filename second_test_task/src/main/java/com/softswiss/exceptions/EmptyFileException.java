package com.softswiss.exceptions;

public class EmptyFileException extends RuntimeException {

    public EmptyFileException() {
        System.out.println("Uploaded file is empty!");
    }
}
