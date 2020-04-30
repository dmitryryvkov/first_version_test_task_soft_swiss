package com.softswiss.exceptions;

public class FileNameException extends RuntimeException {

    public FileNameException() {
        System.out.println("Incorrect file selected!");
    }
}
